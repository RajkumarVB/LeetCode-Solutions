import os, re, json, time, random, datetime
import browser_cookie3
from curl_cffi import requests as cr

# ---------- CONFIG ----------
BROWSER = "chrome"        # chrome, firefox, edge, brave, chromium, opera, safari
OUT = "leetcode-solutions"
ACCEPTED_ONLY = False     # True = skip WA / TLE / etc.
DELAY = 3.0               # base seconds between pages (jitter is added)
MAX_RETRIES = 8
# Optional manual fallback if browser_cookie3 can't read your browser:
MANUAL_SESSION = ""       # LEETCODE_SESSION value
MANUAL_CSRF = ""          # csrftoken value
# ----------------------------

EXT = {"python3": "py", "python": "py", "cpp": "cpp", "java": "java",
       "javascript": "js", "typescript": "ts", "golang": "go", "rust": "rs",
       "csharp": "cs", "c": "c", "kotlin": "kt", "swift": "swift",
       "mysql": "sql", "mssql": "sql", "oraclesql": "sql", "postgresql": "sql",
       "ruby": "rb", "scala": "scala", "php": "php", "dart": "dart", "bash": "sh"}

STATUS = {"Accepted": "AC", "Wrong Answer": "WA", "Time Limit Exceeded": "TLE",
          "Memory Limit Exceeded": "MLE", "Runtime Error": "RE",
          "Compile Error": "CE", "Output Limit Exceeded": "OLE"}

STATE_FILE = os.path.join(OUT, "state.json")
INDEX_FILE = os.path.join(OUT, "index.json")


def pascal(slug):
    return "".join(p.capitalize() for p in re.split(r"[-_]", slug) if p)


def make_session():
    s = cr.Session(impersonate="chrome")
    if MANUAL_SESSION and MANUAL_CSRF:
        s.cookies.set("LEETCODE_SESSION", MANUAL_SESSION.strip(), domain="leetcode.com")
        s.cookies.set("csrftoken", MANUAL_CSRF.strip(), domain="leetcode.com")
    else:
        jar = getattr(browser_cookie3, BROWSER)(domain_name="leetcode.com")
        for c in jar:
            s.cookies.set(c.name, c.value, domain=c.domain)
    csrf = s.cookies.get("csrftoken") or MANUAL_CSRF.strip()
    if not (s.cookies.get("LEETCODE_SESSION") or MANUAL_SESSION):
        raise SystemExit("No LEETCODE_SESSION cookie found. Log in to leetcode.com in "
                         f"{BROWSER} (and close it if its cookie DB is locked), "
                         "or use the MANUAL_* fields.")
    s.headers.update({"Referer": "https://leetcode.com/submissions/",
                      "x-csrftoken": csrf or ""})
    return s


def fetch_page(s, offset):
    for attempt in range(1, MAX_RETRIES + 1):
        r = s.get("https://leetcode.com/api/submissions/",
                  params={"offset": offset, "limit": 20}, timeout=30)
        if r.status_code in (403, 429):
            wait = 30 * attempt + random.uniform(0, 10)
            print(f"  throttled ({r.status_code}) at offset {offset}: "
                  f"{r.text[:100]!r}. Waiting {wait:.0f}s (attempt {attempt}/{MAX_RETRIES})")
            time.sleep(wait)
            continue
        r.raise_for_status()
        return r.json()
    raise SystemExit(f"Gave up at offset {offset}. Wait ~15 min and rerun; it will resume.")


def load_json(path, default):
    if os.path.exists(path):
        with open(path, encoding="utf-8") as f:
            return json.load(f)
    return default


def main():
    os.makedirs(OUT, exist_ok=True)
    state = load_json(STATE_FILE, {"offset": 0})
    index = {e["id"]: e for e in load_json(INDEX_FILE, [])}
    offset = state["offset"]
    s = make_session()
    saved = 0

    print(f"Starting at offset {offset}")
    while True:
        data = fetch_page(s, offset)
        for sub in data["submissions_dump"]:
            status = sub["status_display"]
            if ACCEPTED_ONLY and status != "Accepted":
                continue
            slug, lang = sub["title_slug"], sub["lang"]
            ext = EXT.get(lang, lang)
            date = datetime.datetime.fromtimestamp(sub["timestamp"]).strftime("%Y-%m-%d")
            tag = STATUS.get(status, re.sub(r"\W+", "", status))
            base = pascal(slug) if ext == "java" else slug   # Java: capital first letter
            fname = f"{base}_{date}_{sub['id']}_{tag}.{ext}"

            folder = os.path.join(OUT, slug)
            os.makedirs(folder, exist_ok=True)
            path = os.path.join(folder, fname)
            if not os.path.exists(path):
                with open(path, "w", encoding="utf-8") as f:
                    f.write(sub["code"])
                saved += 1
            index[sub["id"]] = {"id": sub["id"], "slug": slug, "title": sub["title"],
                                "lang": lang, "status": status,
                                "runtime": sub.get("runtime"), "memory": sub.get("memory"),
                                "date": date, "file": f"{slug}/{fname}"}

        offset += 20
        # checkpoint after every page
        with open(STATE_FILE, "w") as f:
            json.dump({"offset": offset}, f)
        with open(INDEX_FILE, "w", encoding="utf-8") as f:
            json.dump(list(index.values()), f, indent=2)
        print(f"offset {offset}: {len(index)} submissions indexed, {saved} new files")

        if not data.get("has_next"):
            break
        time.sleep(DELAY + random.uniform(0, 2))

    os.remove(STATE_FILE)   # finished cleanly
    print(f"\nDone. {len(index)} submissions in {OUT}/")


if __name__ == "__main__":
    main()