"""Regenerate README.md (problem index grouped by pattern). Run from the repo root."""
import json, os, sys
sys.path.insert(0, os.path.dirname(__file__))
from concepts import CONCEPTS, ORDER
from restructure import load_notes

META = json.load(open("study-guide/problem_meta.json"))
notes = load_notes()
rank = {"Easy": 0, "Medium": 1, "Hard": 2}
L = ["# LeetCode Solutions", "",
     "My accepted LeetCode solutions (Java + MySQL), deduplicated and grouped by pattern.", "",
     "- `leetcode-solutions/<problem>/` holds one file per distinct approach (`Name.java`, or `Name_1.java`, `Name_2.java`, ...).",
     "  Each file starts with a paraphrased problem statement, the key idea, the approach and its complexity.",
     "- `attempts/` subfolders keep the wrong-answer / TLE / runtime-error submissions.",
     "- `*_NOT_ACCEPTED.*` marks problems that were never accepted.",
     "- **[Study guide PDF](study-guide/LeetCode-Study-Guide.pdf)**: concepts, templates, and every problem with its key idea and solution.", "",
     "Regenerate after editing `study-guide/notes/*.json`:", "",
     "```bash", "python3 study-guide/update_headers.py   # file headers",
     "python3 study-guide/build_readme.py     # this README",
     "python3 study-guide/build_pdf.py        # PDF (needs: pip install reportlab)", "```", ""]
for p in ORDER:
    slugs = sorted((s for s, n in notes.items() if n["p"] == p),
                   key=lambda s: (rank[META[s]["difficulty"]], int(META[s]["questionFrontendId"])))
    L += [f"## {CONCEPTS[p]['title']} ({len(slugs)})", "", "| # | Problem | Difficulty | Key idea |", "|---|---|---|---|"]
    for s in slugs:
        m, n = META[s], notes[s]
        idea = n["i"].split(". ")[0].replace("|", "/")
        flag = " (not accepted)" if not n["k"] else ""
        L.append(f"| {m['questionFrontendId']} | [{m['title']}](leetcode-solutions/{s}/){flag} | {m['difficulty']} | {idea} |")
    L.append("")
open("README.md", "w").write("\n".join(L))
print("README.md written")
