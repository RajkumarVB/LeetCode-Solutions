"""Rewrite the header comment of every solution file from study-guide/notes/*.json.
Run from the repo root after editing notes:  python3 study-guide/update_headers.py
"""
import json, os, re, sys
sys.path.insert(0, os.path.dirname(__file__))
from restructure import load_notes, pascal, header

META = json.load(open("study-guide/problem_meta.json"))
notes = load_notes()
count = 0
for slug, n in notes.items():
    d = os.path.join("leetcode-solutions", slug)
    name = pascal(slug)
    for f in os.listdir(d):
        m = re.fullmatch(re.escape(name) + r"(?:_(\d+)|_(NOT_ACCEPTED))?\.(java|sql)", f)
        if not m:
            continue
        path = os.path.join(d, f)
        src = open(path).read()
        sub = re.search(r"\* Submitted:\s+(.*)", src).group(1).strip()
        code = re.sub(r"\A/\*.*?\*/\n\n", "", src, count=1, flags=re.S)
        idx = int(m.group(1)) - 1 if m.group(1) else 0
        open(path, "w").write(header(slug, n, META, n["k"], idx, sub, bool(m.group(2))) + "\n" + code)
        count += 1
print("headers rewritten:", count)
