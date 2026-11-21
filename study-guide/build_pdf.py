"""Build study-guide/LeetCode-Study-Guide.pdf from notes/*.json, concepts.py and your solution code.
Needs reportlab:  pip install reportlab
Run from the repo root:  python3 study-guide/build_pdf.py
"""
import datetime, json, os, re, sys
from xml.sax.saxutils import escape

from reportlab.lib import colors
from reportlab.lib.enums import TA_CENTER
from reportlab.lib.pagesizes import A4
from reportlab.lib.styles import ParagraphStyle, getSampleStyleSheet
from reportlab.lib.units import mm
from reportlab.platypus import (BaseDocTemplate, Frame, KeepTogether, PageBreak, PageTemplate,
                                Paragraph, Preformatted, Spacer, Table, TableStyle)
from reportlab.platypus.tableofcontents import TableOfContents

sys.path.insert(0, os.path.dirname(__file__))
from concepts import CONCEPTS, ORDER
from restructure import load_notes, pascal

OUT = "study-guide/LeetCode-Study-Guide.pdf"
META = json.load(open("study-guide/problem_meta.json"))
NOTES = load_notes()

INK = colors.HexColor("#1f2933"); MUTED = colors.HexColor("#616e7c"); ACCENT = colors.HexColor("#2f6fdf")
CODEBG = colors.HexColor("#f5f7fa"); IDEABG = colors.HexColor("#eef4ff"); RULE = colors.HexColor("#d9e2ec")
DIFF = {"Easy": colors.HexColor("#1e8e3e"), "Medium": colors.HexColor("#c77700"), "Hard": colors.HexColor("#c5221f")}

ss = getSampleStyleSheet()
S = {
    "title": ParagraphStyle("t", parent=ss["Title"], fontSize=30, leading=36, textColor=INK),
    "sub": ParagraphStyle("s", parent=ss["Normal"], fontSize=12, leading=17, textColor=MUTED, alignment=TA_CENTER),
    "h1": ParagraphStyle("h1", parent=ss["Heading1"], fontSize=22, leading=27, textColor=ACCENT, spaceAfter=8),
    "h2": ParagraphStyle("h2", parent=ss["Heading2"], fontSize=13, leading=16, textColor=INK, spaceBefore=10, spaceAfter=3),
    "h3": ParagraphStyle("h3", parent=ss["Heading3"], fontSize=10.5, leading=13, textColor=INK, spaceBefore=6, spaceAfter=2),
    "body": ParagraphStyle("b", parent=ss["Normal"], fontSize=9.5, leading=13.5, textColor=INK, spaceAfter=4),
    "small": ParagraphStyle("sm", parent=ss["Normal"], fontSize=8.5, leading=11.5, textColor=INK),
    "muted": ParagraphStyle("m", parent=ss["Normal"], fontSize=8, leading=10.5, textColor=MUTED),
    "bullet": ParagraphStyle("bl", parent=ss["Normal"], fontSize=9.5, leading=13, textColor=INK, leftIndent=12, bulletIndent=2),
    "code": ParagraphStyle("c", fontName="Courier", fontSize=7.2, leading=8.9, textColor=INK),
    "toc0": ParagraphStyle("toc0", fontName="Helvetica-Bold", fontSize=10.5, leading=15, textColor=INK),
    "toc1": ParagraphStyle("toc1", fontName="Helvetica", fontSize=8, leading=10, leftIndent=14, textColor=INK),
}


def clean(s):
    return s.encode("latin-1", "replace").decode("latin-1")


def P(text, style="body"):
    return Paragraph(clean(text), S[style])


W = A4[0] - 36 * mm - 12


def code_box(src, label=None):
    src = clean(src.expandtabs(4))
    lines = src.split("\n")
    rows = [[P(escape(label), "muted")]] if label else []
    for i in range(0, len(lines), 40):          # chunk so long code can split across pages
        rows.append([Preformatted("\n".join(lines[i:i + 40]), S["code"], maxLineLength=116, newLineChars="  ")])
    t = Table(rows, colWidths=[W], splitByRow=1)
    t.setStyle(TableStyle([("BACKGROUND", (0, 0), (-1, -1), CODEBG), ("BOX", (0, 0), (-1, -1), 0.4, RULE),
                           ("LEFTPADDING", (0, 0), (-1, -1), 6), ("RIGHTPADDING", (0, 0), (-1, -1), 6),
                           ("TOPPADDING", (0, 0), (-1, -1), 1), ("BOTTOMPADDING", (0, 0), (-1, -1), 1)]))
    return t


def idea_box(text):
    t = Table([[P("<b>Key idea.</b> " + escape(text), "small")]], colWidths=[W])
    t.setStyle(TableStyle([("BACKGROUND", (0, 0), (-1, -1), IDEABG), ("LINEBEFORE", (0, 0), (0, -1), 2.5, ACCENT),
                           ("LEFTPADDING", (0, 0), (-1, -1), 8), ("TOPPADDING", (0, 0), (-1, -1), 5),
                           ("BOTTOMPADDING", (0, 0), (-1, -1), 6)]))
    return t


def table(rows, widths, header=True, font=8.3):
    t = Table([[P(escape(str(c)) if not isinstance(c, Paragraph) else c, "small") if not isinstance(c, Paragraph) else c
                for c in r] for r in rows], colWidths=widths, repeatRows=1 if header else 0)
    st = [("GRID", (0, 0), (-1, -1), 0.3, RULE), ("VALIGN", (0, 0), (-1, -1), "TOP"),
          ("TOPPADDING", (0, 0), (-1, -1), 2.5), ("BOTTOMPADDING", (0, 0), (-1, -1), 3)]
    if header:
        st += [("BACKGROUND", (0, 0), (-1, 0), colors.HexColor("#e4e7eb"))]
    t.setStyle(TableStyle(st))
    return t


def solution_code(slug, n):
    d = os.path.join("leetcode-solutions", slug)
    name = pascal(slug)
    if n["k"]:
        ext = n["k"][0][0].rsplit(".", 1)[1]
        f = f"{name}.{ext}" if len(n["k"]) == 1 else f"{name}_1.{ext}"
    else:
        cands = [x for x in os.listdir(d) if "NOT_ACCEPTED" in x]
        if not cands:
            return None, None
        f = cands[0]
    src = open(os.path.join(d, f)).read()
    src = re.sub(r"\A/\*.*?\*/\n\n", "", src, count=1, flags=re.S)           # our header
    src = re.sub(r"/\*\*?[^*]*?Definition for.*?\*/\s*", "", src, flags=re.S)  # LeetCode boilerplate
    src = re.sub(r"/\*\*?[^*]*?will be instantiated.*?\*/\s*", "", src, flags=re.S)
    src = re.sub(r"^\s*#\s*Write your MySQL query statement below\s*\n", "", src, flags=re.M)
    lines = [l.rstrip() for l in src.split("\n")]
    out = []
    for l in lines:
        if l == "" and (not out or out[-1] == ""):
            continue
        out.append(l)
    return "\n".join(out).strip("\n"), f"{slug}/{f}"


class Doc(BaseDocTemplate):
    def __init__(self, fn):
        super().__init__(fn, pagesize=A4, leftMargin=18 * mm, rightMargin=18 * mm, topMargin=16 * mm,
                         bottomMargin=16 * mm, title="LeetCode Study Guide", author="Rajkumar")
        frame = Frame(self.leftMargin, self.bottomMargin, self.width, self.height, id="f")
        self.addPageTemplates([PageTemplate(id="p", frames=[frame], onPageEnd=self.footer)])
        self.chapter = ""

    def beforeDocument(self):
        self.chapter = ""

    def footer(self, c, doc):
        if doc.page == 1:
            return
        c.saveState(); c.setFont("Helvetica", 7.5); c.setFillColor(MUTED)
        c.drawString(18 * mm, 9 * mm, "LeetCode Study Guide" + (f"  -  {self.chapter}" if self.chapter else ""))
        c.drawRightString(A4[0] - 18 * mm, 9 * mm, str(doc.page))
        c.restoreState()

    def afterFlowable(self, f):
        if isinstance(f, Paragraph) and hasattr(f, "_toc"):
            level, text, key = f._toc
            self.canv.bookmarkPage(key)
            self.canv.addOutlineEntry(text, key, level=level, closed=level == 0)
            self.notify("TOCEntry", (level, text, self.page, key))
            if level == 0:
                self.chapter = text.split(". ", 1)[-1]


def heading(text, style, level, key):
    p = P(text, style)
    p._toc = (level, re.sub(r"<[^>]+>", "", text), key)
    return p


def problem_flow(slug, n):
    m = META[slug]
    diff = m["difficulty"]
    title = f"{m['questionFrontendId']}. {escape(m['title'])}"
    head = heading(f"{title} <font size=8.5 color='{DIFF[diff].hexval()}'>[{diff}]</font>", "h2", 1, f"p-{slug}")
    head._toc = (1, f"{m['questionFrontendId']}. {m['title']}", f"p-{slug}")
    parts = [head,
             P(f"<font color='#616e7c'>leetcode.com/problems/{slug}  |  {escape(', '.join(m['topics']))}</font>", "muted"),
             Spacer(1, 3),
             P(f"<b>Problem.</b> {escape(n['d'])}"),
             P(f"<b>Example.</b> <font name='Courier' size=8.5>{escape(n['ex'])}</font>   "
               f"<b>Constraints.</b> {escape(n['c'])}", "small"),
             Spacer(1, 4), idea_box(n["i"]), Spacer(1, 4)]
    flow = [KeepTogether(parts)]
    if n["k"]:
        rows = [["Your version", "Approach", "Time", "Space"]]
        for i, k in enumerate(n["k"]):
            ext = k[0].rsplit(".", 1)[1]
            fname = f"{pascal(slug)}.{ext}" if len(n["k"]) == 1 else f"{pascal(slug)}_{i+1}.{ext}"
            rows.append([fname, k[1], k[2], k[3]])
        if n["k"][0][2] != "-":
            flow.append(table(rows, [54 * mm, 72 * mm, 24 * mm, 24 * mm]))
            flow.append(Spacer(1, 4))
    else:
        flow.append(P("<font color='#c5221f'><b>Not accepted yet.</b></font> Your latest attempt is shown below. "
                      "Re-solve it using the key idea above.", "small"))
    code, label = solution_code(slug, n)
    if code:
        flow.append(code_box(code, label + ("  (primary version)" if len(n["k"]) > 1 else "")))
    flow.append(Spacer(1, 10))
    return flow


def build():
    by_pat = {p: [] for p in ORDER}
    for slug, n in NOTES.items():
        by_pat[n["p"]].append(slug)
    rank = {"Easy": 0, "Medium": 1, "Hard": 2}
    for p in by_pat:
        by_pat[p].sort(key=lambda s: (rank[META[s]["difficulty"]], int(META[s]["questionFrontendId"])))

    counts = {d: sum(1 for s in NOTES if META[s]["difficulty"] == d) for d in rank}
    kept = sum(len(n["k"]) for n in NOTES.values())
    story = [Spacer(1, 55 * mm), P("LeetCode Study Guide", "title"), Spacer(1, 6),
             P("Patterns, key ideas and your own solutions, organised for revision", "sub"), Spacer(1, 18 * mm),
             P(f"{len(NOTES)} problems &nbsp;|&nbsp; <font color='#1e8e3e'>{counts['Easy']} Easy</font> &nbsp; "
               f"<font color='#c77700'>{counts['Medium']} Medium</font> &nbsp; <font color='#c5221f'>{counts['Hard']} Hard</font>"
               f" &nbsp;|&nbsp; {kept} solution versions &nbsp;|&nbsp; {len(ORDER)} patterns", "sub"),
             Spacer(1, 4), P(f"Generated {datetime.date.today():%d %B %Y}", "sub"), PageBreak()]

    # how to use + cheat sheet
    story += [P("How to use this guide", "h1"),
              P("Each chapter starts with the <b>concept</b>: what the pattern is, the signals that point to it, a Java template, and common pitfalls. "
                "Then come <b>your problems</b> for that pattern, easiest first. Each has a paraphrased statement, the key idea, a table of the "
                "approaches you've written with their complexity, and your primary solution."),
              P("<b>Suggested revision loop:</b> read the chapter concept, then for each problem read only the statement and try to recall the idea "
                "before looking at the blue box. Re-solve the ones you couldn't recall on LeetCode. The checklist at the end tracks progress."),
              P("Problem statements are paraphrased; click through to LeetCode for the full text. "
                "Use the PDF bookmarks (sidebar) to jump to any problem."),
              Spacer(1, 6), P("Pattern recognition cheat sheet", "h2")]
    rows = [["Pattern", "Reach for it when...", "#"]]
    for p in ORDER:
        rows.append([CONCEPTS[p]["title"], "; ".join(CONCEPTS[p]["signals"][:3]), str(len(by_pat[p]))])
    story += [table(rows, [38 * mm, 128 * mm, 8 * mm]), PageBreak()]

    toc = TableOfContents(); toc.levelStyles = [S["toc0"], S["toc1"]]
    story += [P("Contents", "h1"), toc, PageBreak()]

    for ci, p in enumerate(ORDER, 1):
        c = CONCEPTS[p]
        story.append(heading(f"{ci}. {c['title']}", "h1", 0, f"c-{p}"))
        story += [P(t) for t in c["intro"]]
        story.append(P("Signals", "h3"))
        story += [Paragraph(clean(escape(s)), S["bullet"], bulletText="-") for s in c["signals"]]
        story.append(P("Template", "h3"))
        story.append(code_box(c["template"]))
        story.append(P("Pitfalls", "h3"))
        story += [Paragraph(clean(escape(s)), S["bullet"], bulletText="!") for s in c["pitfalls"]]
        story.append(P(f"Your problems ({len(by_pat[p])})", "h3"))
        story.append(P(", ".join(f"{META[s]['questionFrontendId']}. {escape(META[s]['title'])}" for s in by_pat[p]), "small"))
        story.append(PageBreak())
        for slug in by_pat[p]:
            story += problem_flow(slug, NOTES[slug])
        story.append(PageBreak())

    # checklist
    story.append(heading("Revision checklist", "h1", 0, "checklist"))
    story.append(P("Tick a box each time you re-solve a problem from scratch without looking.", "small"))
    rows = [["Pattern", "Problem", "Diff", "1st", "2nd", "3rd"]]
    for p in ORDER:
        for s in by_pat[p]:
            m = META[s]
            rows.append([CONCEPTS[p]["title"], f"{m['questionFrontendId']}. {m['title']}", m["difficulty"], "[ ]", "[ ]", "[ ]"])
    story.append(table(rows, [40 * mm, 86 * mm, 16 * mm, 10 * mm, 10 * mm, 10 * mm]))

    doc = Doc(OUT)
    doc.multiBuild(story)
    print("wrote", OUT)


if __name__ == "__main__":
    build()
