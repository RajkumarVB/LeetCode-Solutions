"""One-off script: dedupe leetcode-solutions/ using study-guide/notes/*.json.

For each problem folder:
  * kept Accepted solutions  -> <Name>.java (or <Name>_1.java, <Name>_2.java ...) with a header comment
  * other Accepted copies    -> deleted (still in git history)
  * failed attempts          -> attempts/
  * problems never accepted  -> latest attempt copied to <Name>_NOT_ACCEPTED.java with a header
Run from the repo root:  python3 study-guide/restructure.py
"""
import glob, json, os, re, shutil, subprocess, sys, textwrap

ROOT = "leetcode-solutions"
META = json.load(open(sys.argv[1])) if len(sys.argv) > 1 else {}
DRY = "--dry" in sys.argv


def load_notes():
    notes = {}
    for f in sorted(glob.glob("study-guide/notes/*.json")):
        notes.update(json.load(open(f)))
    return notes


def pascal(slug):
    return "".join(p.capitalize() for p in re.split(r"[-_]", slug) if p)


def git(*args):
    if DRY:
        print("git", *args)
    else:
        subprocess.run(["git", *args], check=True, capture_output=True)


def wrap(label, text, width=92):
    pre = " * " + label
    lines = textwrap.wrap(text, width=width - len(pre), break_long_words=False) or [""]
    out = [pre + lines[0]]
    out += [" * " + " " * len(label) + l for l in lines[1:]]
    return out


def header(slug, n, meta, kept, idx, sub_info, not_accepted=False):
    m = meta.get(slug, {})
    title = m.get("title", slug)
    num = m.get("questionFrontendId", "?")
    diff = m.get("difficulty", "?")
    topics = ", ".join(m.get("topics", []))
    L = ["/*", f" * {num}. {title}  [{diff}]", f" * https://leetcode.com/problems/{slug}/"]
    if topics:
        L += wrap("Topics: ", topics)
    L.append(" *")
    L += wrap("Problem:     ", n["d"])
    L += wrap("Example:     ", n["ex"])
    L += wrap("Constraints: ", n["c"])
    L.append(" *")
    L += wrap("Key idea:    ", n["i"])
    L.append(" *")
    if not_accepted:
        L += wrap("STATUS:      ", "NOT ACCEPTED - this is your latest attempt. Earlier attempts are in attempts/.")
    else:
        f, appr, t, s = kept[idx]
        L += wrap("Approach:    ", appr)
        if t != "-":
            L.append(f" * Complexity:  time {t}, space {s}")
        if len(kept) > 1:
            others = [f"_{j+1}: {k[1]}" for j, k in enumerate(kept) if j != idx]
            L += wrap("Also see:    ", "; ".join(others))
    L.append(f" * Submitted:   {sub_info}")
    L.append(" */")
    # sanitise accidental comment terminators inside text lines
    fixed = [l if l == " */" else l.replace("*/", "* /") for l in L]
    return "\n".join(fixed) + "\n"


def sub_info(fname):
    m = re.search(r"_(\d{4}-\d{2}-\d{2})_(\d+)_([A-Z]+)\.", fname)
    return f"{m.group(1)} (submission {m.group(2)}, {m.group(3)})" if m else fname


def main():
    notes = load_notes()
    stats = {"kept": 0, "deleted": 0, "attempts": 0, "unsolved": 0}
    for slug in sorted(notes):
        n = notes[slug]
        d = os.path.join(ROOT, slug)
        files = sorted(f for f in os.listdir(d) if os.path.isfile(os.path.join(d, f)))
        keep = [k[0] for k in n["k"]]
        name = pascal(slug)
        failed = [f for f in files if not re.search(r"_AC\.\w+$", f)]
        dup_ac = [f for f in files if re.search(r"_AC\.\w+$", f) and f not in keep]
        # 1. delete duplicate accepted copies
        for f in dup_ac:
            git("rm", "-q", os.path.join(d, f)); stats["deleted"] += 1
        # 2. move failed attempts into attempts/
        if failed:
            os.makedirs(os.path.join(d, "attempts"), exist_ok=True)
            for f in failed:
                git("mv", os.path.join(d, f), os.path.join(d, "attempts", f)); stats["attempts"] += 1
        # 3. rename kept files + add header
        for i, f in enumerate(keep):
            ext = f.rsplit(".", 1)[1]
            new = f"{name}.{ext}" if len(keep) == 1 else f"{name}_{i+1}.{ext}"
            src, dst = os.path.join(d, f), os.path.join(d, new)
            git("mv", src, dst)
            if not DRY:
                code = open(dst).read()
                open(dst, "w").write(header(slug, n, META, n["k"], i, sub_info(f)) + "\n" + code)
            stats["kept"] += 1
        # 4. never accepted: surface latest attempt
        if not keep and failed:
            latest = max(failed, key=lambda f: int(re.search(r"_(\d+)_[A-Z]+\.", f).group(1)))
            ext = latest.rsplit(".", 1)[1]
            dst = os.path.join(d, f"{name}_NOT_ACCEPTED.{ext}")
            if not DRY:
                code = open(os.path.join(d, "attempts", latest)).read()
                open(dst, "w").write(header(slug, n, META, [], 0, sub_info(latest), True) + "\n" + code)
                git("add", dst)
            stats["unsolved"] += 1
    print(stats)


if __name__ == "__main__":
    main()
