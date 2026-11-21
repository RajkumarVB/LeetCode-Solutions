"""Chapter text for the study guide: one entry per pattern code used in notes/*.json."""

ORDER = ["AH", "TP", "SW", "ST", "BS", "LL", "TR", "TRIE", "HP", "BT",
         "GR", "AG", "DP1", "DP2", "GD", "IV", "MG", "BIT", "SQL"]

CONCEPTS = {
"AH": {
 "title": "Arrays & Hashing",
 "intro": [
  "Most array problems come down to remembering something about the elements you've already seen. A HashMap or HashSet gives O(1) average lookups, so you swap a nested loop for one pass plus extra memory.",
  "Typical things to remember: a value and its index (Two Sum), frequencies (anagrams, top-k), a canonical key that groups equivalent items (sorted string or 26-count array), and prefix sums (subarray sums)."],
 "signals": ["'Find a pair or complement' -> map value to index", "'Group things that are equivalent' -> map canonicalKey to list",
             "'Count subarrays with sum k' (negatives allowed) -> prefix sum + map of counts", "'Majority / more than n/k times' -> Boyer-Moore voting",
             "'Need O(n) but sorting is O(n log n)' -> HashSet or bucket sort"],
 "template": """// Prefix-sum + HashMap (count subarrays summing to k)
Map<Integer,Integer> seen = new HashMap<>();
seen.put(0, 1);                       // the empty prefix
int sum = 0, count = 0;
for (int x : nums) {
    sum += x;
    count += seen.getOrDefault(sum - k, 0);
    seen.merge(sum, 1, Integer::sum);
}""",
 "pitfalls": ["Seed prefix maps with {0:1}.", "int[26] beats a HashMap for lowercase letters.",
              "Keys must be value-based: records or strings, not int[] arrays."]},
"TP": {
 "title": "Two Pointers",
 "intro": [
  "Two indices move through the data according to a rule, so each element is looked at a constant number of times. There are three common shapes: <b>opposite ends</b> moving inward (sorted pair sums, palindromes, container), <b>slow/fast writers</b> for in-place compaction (remove duplicates, move zeros), and <b>expand from centre</b> (palindromic substrings).",
  "The opposite-ends pattern works on sorted data because of monotonicity: if the sum is too small, only moving the left pointer can increase it."],
 "signals": ["Sorted array + pair/triple sum", "'In place' with O(1) extra space", "Palindrome checks", "k-Sum: sort, fix k-2 elements, then two pointers"],
 "template": """Arrays.sort(a);
int l = 0, r = a.length - 1;
while (l < r) {
    int s = a[l] + a[r];
    if (s == target) { /* record */ l++; r--; }
    else if (s < target) l++;
    else r--;
}
// slow/fast compaction
int w = 0;
for (int x : a) if (keep(x)) a[w++] = x;""",
 "pitfalls": ["Skip equal neighbours to avoid duplicate tuples (3Sum/4Sum).", "Use long when adding several values up to 1e9.",
              "Dutch flag: don't advance mid after swapping with high."]},
"SW": {
 "title": "Sliding Window",
 "intro": [
  "A window [left, right] slides over the array or string. Grow the right edge each step; shrink from the left while the window breaks the condition (variable window), or keep the size fixed (fixed window). Each index enters and leaves once, so the whole scan is O(n).",
  "State inside the window is usually a count array or map, plus a summary number (distinct count, maxFreq, 'have vs need') so each check is O(1)."],
 "signals": ["'Longest/shortest substring or subarray such that...'", "Contiguous plus a constraint that stays monotone as the window grows",
             "Fixed size k: permutations/anagrams in a string", "Window max/min -> monotonic deque"],
 "template": """int[] cnt = new int[128];
int left = 0, best = 0;
for (int right = 0; right < s.length(); right++) {
    cnt[s.charAt(right)]++;
    while (windowInvalid(cnt)) {
        cnt[s.charAt(left++)]--;
    }
    best = Math.max(best, right - left + 1);
}""",
 "pitfalls": ["Sliding windows break with negative numbers when summing; use prefix sums instead.",
              "Minimum window: record the answer inside the shrink loop.", "Deque stores indices, not values."]},
"ST": {
 "title": "Stack & Monotonic Stack",
 "intro": [
  "Use a stack whenever the most recent unfinished item must be resolved first: matching brackets, evaluating expressions, undo-style designs.",
  "A <b>monotonic stack</b> keeps elements in increasing or decreasing order. When a new element breaks the order, everything popped has just found its 'next greater/smaller element'. That solves next-greater, daily temperatures, histogram rectangles and car fleets in O(n)."],
 "signals": ["Matching / nesting", "'Next greater/smaller element' or 'how many days until...'", "Area spans bounded by smaller bars", "Need min/max in O(1) alongside push/pop"],
 "template": """// next greater element to the right (stores indices)
int[] ans = new int[n];
Arrays.fill(ans, -1);
Deque<Integer> st = new ArrayDeque<>();
for (int i = 0; i < n; i++) {
    while (!st.isEmpty() && a[st.peek()] < a[i]) {
        ans[st.pop()] = a[i];
    }
    st.push(i);
}""",
 "pitfalls": ["Prefer ArrayDeque over Stack or LinkedList.", "Circular arrays: loop over 2n indices with i % n.",
              "Decide strict vs non-strict comparisons when there are duplicates."]},
"BS": {
 "title": "Binary Search",
 "intro": [
  "Binary search works on anything <b>monotone</b>, not just sorted arrays. Find the boundary where a predicate flips from false to true. Classic uses: index lookup, first/last occurrence (lower/upper bound), rotated arrays (one half is always sorted), and <b>binary search on the answer</b> (Koko, capacity, sqrt), where you guess a value and check feasibility.",
  "Keep an <i>ans</i> variable and always shrink toward the side that could still hold a better answer."],
 "signals": ["Sorted input and O(log n) required", "'Minimum X such that feasible(X)'", "Rotated sorted array", "Matrix sorted row-major -> treat it as 1-D"],
 "template": """int lo = 0, hi = n - 1, ans = -1;
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;   // no overflow
    if (ok(mid)) { ans = mid; hi = mid - 1; }  // first true
    else lo = mid + 1;
}
// on the answer: lo = minPossible, hi = maxPossible""",
 "pitfalls": ["mid = lo + (hi - lo) / 2.", "Use long for mid*mid or sums of hours.", "Rotated with duplicates: shrink both ends when they are equal."]},
"LL": {
 "title": "Linked List",
 "intro": [
  "Linked list questions are mostly pointer bookkeeping, built from a handful of moves: <b>dummy head</b> (no special case for the first node), <b>reverse</b> (prev/curr/next), <b>slow/fast pointers</b> (middle, cycle detection, nth from end), and <b>merge</b> two sorted lists.",
  "Harder problems combine them. Reorder List = middle + reverse + merge. Palindrome list = middle + reverse + compare. Sort List = middle + recursive merge sort."],
 "signals": ["'In place, O(1) memory'", "Cycle / duplicate in [1..n] -> Floyd", "Nth from end -> two pointers n apart", "O(1) get/put with recency -> HashMap + doubly linked list (LRU)"],
 "template": """ListNode prev = null, cur = head;          // reverse
while (cur != null) {
    ListNode nxt = cur.next;
    cur.next = prev; prev = cur; cur = nxt;
}
ListNode slow = head, fast = head;          // middle
while (fast != null && fast.next != null) {
    slow = slow.next; fast = fast.next.next;
}""",
 "pitfalls": ["Save next before rewiring.", "Floyd phase 2: reset one pointer to head, then step both by 1.",
              "java.util.LinkedList.remove(obj) is O(n); write your own doubly linked list for LRU."]},
"TR": {
 "title": "Trees",
 "intro": [
  "Nearly every tree problem is a DFS where you decide what each call <b>returns</b> (bottom-up: height, sum, a pair of states) and what it <b>receives</b> (top-down: path max, allowed range, depth). Use a global or field for answers that 'bend' at a node, such as diameter and max path sum.",
  "BFS with a queue, reading q.size() at the start of each level, handles level order, right side view, zigzag, and 'distance k' (after adding parent pointers). For BSTs, remember that inorder traversal is sorted and that values guide the search."],
 "signals": ["Height / balance / diameter -> post-order returning height", "Per-level output -> BFS with a size loop",
             "BST validity -> pass (min, max) bounds", "Treat the tree as a graph -> parent map + BFS", "Rebuild from traversals -> root + inorder index map"],
 "template": """int best = Integer.MIN_VALUE;
int dfs(TreeNode node) {                 // post-order
    if (node == null) return 0;
    int l = Math.max(0, dfs(node.left));
    int r = Math.max(0, dfs(node.right));
    best = Math.max(best, node.val + l + r);  // path bending here
    return node.val + Math.max(l, r);         // path going up
}
// BFS levels
Queue<TreeNode> q = new ArrayDeque<>(List.of(root));
while (!q.isEmpty()) {
    for (int i = 0, sz = q.size(); i < sz; i++) { /* poll, push children */ }
}""",
 "pitfalls": ["Reset global fields inside the public method (LeetCode reuses objects).", "Use long bounds for BST validation.",
              "Diameter counts edges; max path sum counts values."]},
"TRIE": {
 "title": "Tries",
 "intro": [
  "A trie stores strings character by character, so all words sharing a prefix share a path. Insert, search and startsWith cost O(L). The key payoff is <b>pruning</b>: in Word Search II, one DFS over the board walks down the trie and stops as soon as no word has that prefix."],
 "signals": ["Many prefix queries", "Search many words at once in a grid or text", "Autocomplete / dictionary"],
 "template": """class Node { Node[] next = new Node[26]; boolean end; }
void insert(String w) {
    Node cur = root;
    for (char c : w.toCharArray()) {
        if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new Node();
        cur = cur.next[c - 'a'];
    }
    cur.end = true;
}""",
 "pitfalls": ["search needs end == true; startsWith doesn't.", "Word Search II: collect results in a Set or clear end flags to avoid duplicates."]},
"HP": {
 "title": "Heap / Priority Queue",
 "intro": [
  "A heap gives the min or max in O(1) and insert/remove in O(log n). Common shapes: <b>size-k min-heap</b> for the k largest (top-k, kth largest, k closest), <b>two heaps</b> for a running median, <b>k-way merge</b> (merge k lists, Twitter feed), and <b>greedy by best gain</b> (task scheduler, pass ratio)."],
 "signals": ["'k largest / smallest / closest / most frequent'", "Streaming data with order statistics", "Repeatedly take the current best"],
 "template": """PriorityQueue<Integer> pq = new PriorityQueue<>();   // min-heap
for (int x : nums) {
    pq.offer(x);
    if (pq.size() > k) pq.poll();          // keep k largest
}
int kthLargest = pq.peek();
// max-heap: new PriorityQueue<>((a, b) -> b - a)  (or Collections.reverseOrder())""",
 "pitfalls": ["Comparator (a, b) -> a - b can overflow; prefer Integer.compare.", "Compare squared distances, not sqrt.",
              "Two heaps: keep sizes within 1 and small.peek() <= large.peek()."]},
"BT": {
 "title": "Backtracking",
 "intro": [
  "Backtracking explores a decision tree: <b>choose -> recurse -> un-choose</b>. Subsets use take/skip per element. Combinations and partitions loop over the next start index. Permutations use any unused element. Board problems (N-Queens, Sudoku, word search) place, recurse, and undo.",
  "Duplicates in the input: sort first, then skip nums[i] == nums[i-1] at the same depth (i > start)."],
 "signals": ["'Return all ...' combinations, subsets, permutations, partitions", "Small n (<= 20)", "Constraint satisfaction on a board"],
 "template": """void bt(int start, List<Integer> path) {
    res.add(new ArrayList<>(path));            // or check a goal
    for (int i = start; i < n; i++) {
        if (i > start && a[i] == a[i - 1]) continue; // skip dups
        path.add(a[i]);
        bt(i + 1, path);                      // i (not i+1) if reuse allowed
        path.remove(path.size() - 1);
    }
}""",
 "pitfalls": ["Copy the path when saving it.", "Prune early (sorted input + break).", "Restore any board cell you mark."]},
"GR": {
 "title": "Graphs: BFS / DFS",
 "intro": [
  "Grids and adjacency lists are graphs. <b>DFS</b> (recursive flood fill) is great for counting or marking components. <b>BFS</b> finds shortest paths in unweighted graphs. <b>Multi-source BFS</b> (rotting oranges) starts with every source in the queue at time 0.",
  "<b>Reverse thinking</b> helps: start from the border or ocean and mark what's reachable (Pacific-Atlantic, surrounded regions). Two-colouring checks bipartiteness."],
 "signals": ["Islands / regions / connected cells", "Minimum steps in an unweighted grid", "Spreading over time from many sources", "Copy a graph -> DFS with old->new map"],
 "template": """int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
Queue<int[]> q = new ArrayDeque<>();
q.add(new int[]{sr, sc}); seen[sr][sc] = true;
int steps = 0;
while (!q.isEmpty()) {
    for (int sz = q.size(); sz > 0; sz--) {
        int[] c = q.poll();
        for (int[] d : dirs) {
            int r = c[0] + d[0], col = c[1] + d[1];
            if (r < 0 || col < 0 || r >= m || col >= n || seen[r][col] || blocked(r, col)) continue;
            seen[r][col] = true;               // mark when enqueuing
            q.add(new int[]{r, col});
        }
    }
    steps++;
}""",
 "pitfalls": ["Mark visited when you enqueue, not when you dequeue.", "BFS levels = minutes/steps.", "Bus routes: BFS over buses, not stops."]},
"AG": {
 "title": "Advanced Graphs",
 "intro": [
  "<b>Topological sort (Kahn)</b>: repeatedly remove in-degree-0 nodes. If not every node is removed, there's a cycle (course schedule). <b>Dijkstra</b>: min-heap by distance for non-negative weights (network delay). Variants minimise a path maximum (swim in water) or cap the number of edges (cheapest flights: BFS by stops / Bellman-Ford).",
  "<b>Union-Find</b> (union by size + path compression) answers 'are these connected?' in almost O(1): redundant edges, component counts, stones removed. <b>MST</b>: Prim (heap) or Kruskal (sort + union-find)."],
 "signals": ["Prerequisites / ordering -> topological sort", "Weighted shortest path -> Dijkstra", "Dynamic connectivity / extra edge -> union-find", "Connect everything cheapest -> MST"],
 "template": """// Dijkstra
int[] dist = new int[n]; Arrays.fill(dist, Integer.MAX_VALUE); dist[src] = 0;
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
pq.add(new int[]{src, 0});
while (!pq.isEmpty()) {
    int[] cur = pq.poll();
    if (cur[1] > dist[cur[0]]) continue;          // stale entry
    for (int[] e : adj.get(cur[0]))
        if (cur[1] + e[1] < dist[e[0]]) {
            dist[e[0]] = cur[1] + e[1];
            pq.add(new int[]{e[0], dist[e[0]]});
        }
}
// Union-Find
int find(int x) { return p[x] == x ? x : (p[x] = find(p[x])); }""",
 "pitfalls": ["Dijkstra can't handle negative edges.", "Cheapest flights: plain Dijkstra ignores the stop limit.", "Safe states: reverse the edges, then run Kahn."]},
"DP1": {
 "title": "1-D Dynamic Programming",
 "intro": [
  "DP = recursion + caching. Define a state (usually an index), write the recurrence from a few choices, and give base cases. Then pick one of three styles: <b>memoised recursion</b> (top-down), <b>tabulation</b> (bottom-up), or <b>space-optimised</b> (keep only the last few values). Your solutions often show all three.",
  "Core recurrences: Fibonacci/stairs f(i) = f(i-1) + f(i-2). House robber f(i) = max(f(i-1), a[i] + f(i-2)). Kadane: best ending here = max(a[i], a[i] + prev). Word break / decode ways: try each next piece."],
 "signals": ["'Number of ways', 'min/max cost', 'can you reach'", "Choice at each index that depends on earlier results", "Brute force recursion repeats the same subproblems"],
 "template": """// top-down
int[] memo = new int[n]; Arrays.fill(memo, -1);
int f(int i) {
    if (i < 0) return 0;
    if (memo[i] != -1) return memo[i];
    return memo[i] = Math.max(f(i - 1), a[i] + f(i - 2));
}
// bottom-up, O(1) space
int prev2 = 0, prev1 = 0;
for (int x : a) { int cur = Math.max(prev1, x + prev2); prev2 = prev1; prev1 = cur; }""",
 "pitfalls": ["Circular arrays: solve two linear cases.", "Max product: track both max and min.", "Use a big sentinel (1e9) instead of MAX_VALUE to avoid overflow when adding."]},
"DP2": {
 "title": "2-D Dynamic Programming",
 "intro": [
  "Two indices make the state: (i, j) in a grid, or prefix lengths of two strings. <b>Grid paths</b>: f(i,j) = f(i-1,j) + f(i,j-1). <b>LCS family</b>: if chars match, 1 + f(i-1,j-1), else max(f(i-1,j), f(i,j-1)). Edit distance, delete operations, palindromic subsequence, insertions-to-palindrome and shortest common supersequence are all LCS variants.",
  "<b>Knapsack</b>: f(i, t) = notTake f(i-1, t) or take f(i-1, t - w[i]) (0/1) or f(i, t - w[i]) (unbounded: coin change). Roll rows to get O(columns) space."],
 "signals": ["Two strings compared character by character", "Grid with right/down moves", "Subset to a target sum / limited capacity", "Count combinations of coins"],
 "template": """int[][] dp = new int[n + 1][m + 1];      // LCS
for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++)
        dp[i][j] = s.charAt(i-1) == t.charAt(j-1)
                 ? 1 + dp[i-1][j-1]
                 : Math.max(dp[i-1][j], dp[i][j-1]);
// 0/1 knapsack (1-D): iterate target DOWNWARDS
for (int w : nums) for (int t = T; t >= w; t--) can[t] |= can[t - w];""",
 "pitfalls": ["Use 1-based dp indices with s.charAt(i-1).", "1-D 0/1 knapsack loops t downwards; unbounded loops upwards.",
              "Coins in the outer loop count combinations; amount in the outer loop counts permutations."]},
"GD": {
 "title": "Greedy",
 "intro": [
  "A greedy algorithm makes the locally best choice and never undoes it. It's correct when an exchange argument shows that any optimal solution can be changed to include the greedy choice. Usually you sort first, or scan while tracking a running best.",
  "Patterns from your problems: reachability frontier (jump game), reset the start when a running sum goes negative (gas station), two passes left and right (candy), last-occurrence boundaries (partition labels), and range of possibilities (valid parenthesis string)."],
 "signals": ["Sorting makes the decision obvious", "'Minimum number of ...' with a simple local rule", "A DP that seems to need only the best previous state"],
 "template": """// jump game: farthest reach
int reach = 0;
for (int i = 0; i < n; i++) {
    if (i > reach) return false;
    reach = Math.max(reach, i + nums[i]);
}
return true;""",
 "pitfalls": ["Prove it (or find a counterexample) before trusting the greedy rule.", "Many greedy problems need sorting by the right key."]},
"IV": {
 "title": "Intervals",
 "intro": [
  "Almost always sort first: by start for merging and inserting, or by end for maximising non-overlapping intervals. Two intervals overlap when a.start <= b.end and b.start <= a.end. After sorting by start, you only need to compare with the last merged interval."],
 "signals": ["Meetings, ranges, schedules", "Merge / insert / remove overlaps"],
 "template": """Arrays.sort(iv, (a, b) -> Integer.compare(a[0], b[0]));
List<int[]> out = new ArrayList<>();
for (int[] cur : iv) {
    if (out.isEmpty() || out.get(out.size()-1)[1] < cur[0]) out.add(cur);
    else out.get(out.size()-1)[1] = Math.max(out.get(out.size()-1)[1], cur[1]);
}""",
 "pitfalls": ["Check whether touching endpoints count as overlap.", "Non-overlapping: on a clash, keep the interval with the smaller end."]},
"MG": {
 "title": "Math & Geometry / Matrix",
 "intro": [
  "Digit manipulation (x % 10, x / 10) with overflow checks against MAX/10 before multiplying. Matrix tricks: rotate = transpose + reverse rows; spiral = shrinking boundaries; set zeros in O(1) space using the first row and column as markers. Use 2-D prefix sums for rectangle sums."],
 "signals": ["Reverse / parse integers", "In-place matrix transforms", "Counting via parity or formulas"],
 "template": """// overflow-safe digit append
if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && d > 7)) return Integer.MAX_VALUE;
res = res * 10 + d;
// rotate 90 degrees clockwise
for (int i = 0; i < n; i++) for (int j = i + 1; j < n; j++) swap(m, i, j, j, i);
for (int[] row : m) reverse(row);""",
 "pitfalls": ["Spiral: re-check bounds before the bottom and left passes.", "Negative modulo in Java keeps the sign of the dividend."]},
"BIT": {
 "title": "Bit Manipulation",
 "intro": [
  "XOR facts: x ^ x = 0, x ^ 0 = x, and XOR is commutative, so pairs cancel (single number, missing number). x & (x - 1) clears the lowest set bit; x & -x isolates it (single number III). A bitmask from 0 to 2^n - 1 enumerates every subset."],
 "signals": ["'Every element appears twice except...'", "O(1) space with integer tricks", "Enumerate subsets of small n"],
 "template": """int x = 0; for (int v : nums) x ^= v;     // cancel pairs
int low = x & -x;                         // lowest set bit
int bits = 0; while (n != 0) { n &= n - 1; bits++; }
for (int mask = 0; mask < (1 << n); mask++)
    for (int j = 0; j < n; j++) if ((mask >> j & 1) == 1) { /* take j */ }""",
 "pitfalls": ["Use >>> (unsigned shift) in Java for bit reversal.", "1 << 31 is negative in an int."]},
"SQL": {
 "title": "SQL",
 "intro": [
  "Building blocks you used: WHERE filters (watch NULLs: NULL != 2 is not TRUE, so add IS NULL), INNER versus LEFT JOIN (LEFT keeps unmatched rows), self-joins to compare rows in the same table (start/end, yesterday's temperature), GROUP BY + HAVING for aggregate filters, ORDER BY + LIMIT for top-1, and subqueries such as MAX below MAX."],
 "signals": ["'For each X...' -> GROUP BY", "'Even if missing' -> LEFT JOIN", "Compare a row to another row of the same table -> self-join"],
 "template": """SELECT c.id, COUNT(o.id) AS cnt
FROM Customers c
LEFT JOIN Orders o ON o.customer_id = c.id
WHERE c.region IS NOT NULL
GROUP BY c.id
HAVING COUNT(o.id) > 1
ORDER BY cnt DESC
LIMIT 1;""",
 "pitfalls": ["WHERE runs before grouping; HAVING runs after.", "An aggregate over no rows returns NULL, which is handy for 'return null if none'."]},
}
