# LeetCode Solutions

My accepted LeetCode solutions (Java + MySQL), deduplicated and grouped by pattern.

- `leetcode-solutions/<problem>/` holds one file per distinct approach (`Name.java`, or `Name_1.java`, `Name_2.java`, ...).
  Each file starts with a paraphrased problem statement, the key idea, the approach and its complexity.
- `attempts/` subfolders keep the wrong-answer / TLE / runtime-error submissions.
- `*_NOT_ACCEPTED.*` marks problems that were never accepted.
- **[Study guide PDF](study-guide/LeetCode-Study-Guide.pdf)**: concepts, templates, and every problem with its key idea and solution.

Regenerate after editing `study-guide/notes/*.json`:

```bash
python3 study-guide/update_headers.py   # file headers
python3 study-guide/build_readme.py     # this README
python3 study-guide/build_pdf.py        # PDF (needs: pip install reportlab)
```

## Arrays & Hashing (25)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 1 | [Two Sum](leetcode-solutions/two-sum/) | Easy | One pass with a HashMap value -> index: for each x, if target - x has been seen, you're done; otherwise store x. |
| 14 | [Longest Common Prefix](leetcode-solutions/longest-common-prefix/) | Easy | Vertical scan: compare character i across all strings up to the shortest length |
| 169 | [Majority Element](leetcode-solutions/majority-element/) | Easy | Boyer-Moore voting: keep a candidate and a count |
| 217 | [Contains Duplicate](leetcode-solutions/contains-duplicate/) | Easy | Use a HashSet and return as soon as a value is already in it |
| 242 | [Valid Anagram](leetcode-solutions/valid-anagram/) | Easy | An int[26] count: increment for s, decrement for t, then check all zeros |
| 350 | [Intersection of Two Arrays II](leetcode-solutions/intersection-of-two-arrays-ii/) | Easy | Count one array in a map, then walk the other and take a value whenever its count is still positive (decrementing) |
| 387 | [First Unique Character in a String](leetcode-solutions/first-unique-character-in-a-string/) | Easy | Two passes: count frequencies (an int[26] is enough), then return the first index whose count is 1. |
| 485 | [Max Consecutive Ones](leetcode-solutions/max-consecutive-ones/) | Easy | Running counter that resets on 0; track the maximum. |
| 575 | [Distribute Candies](leetcode-solutions/distribute-candies/) | Easy | Answer = min(number of distinct types, n/2) |
| 1422 | [Maximum Score After Splitting a String](leetcode-solutions/maximum-score-after-splitting-a-string/) | Easy | Precompute suffix counts of ones (or start with the total ones and subtract as you go), then scan each split point once. |
| 1496 | [Path Crossing](leetcode-solutions/path-crossing/) | Easy | Track visited coordinates in a HashSet |
| 1624 | [Largest Substring Between Two Equal Characters](leetcode-solutions/largest-substring-between-two-equal-characters/) | Easy | Store each character's first index; for each later occurrence the answer candidate is i - first[c] - 1 |
| 1752 | [Check if Array Is Sorted and Rotated](leetcode-solutions/check-if-array-is-sorted-and-rotated/) | Easy | Count the 'drops' where nums[i] > nums[(i+1) % n] (circularly) |
| 1758 | [Minimum Changes To Make Alternating Binary String](leetcode-solutions/minimum-changes-to-make-alternating-binary-string/) | Easy | Only two targets exist: 0101.. |
| 1929 | [Concatenation of Array](leetcode-solutions/concatenation-of-array/) | Easy | result[i] = nums[i % n]. |
| 3069 | [Distribute Elements Into Two Arrays I](leetcode-solutions/distribute-elements-into-two-arrays-i/) | Easy | Direct simulation. |
| 36 | [Valid Sudoku](leetcode-solutions/valid-sudoku/) | Medium | Nine HashSets each for rows, columns and boxes |
| 38 | [Count and Say](leetcode-solutions/count-and-say/) | Medium | Build each term from the previous one by scanning runs of equal characters and appending count + char. |
| 49 | [Group Anagrams](leetcode-solutions/group-anagrams/) | Medium | Anagrams share a canonical key: the sorted string, or the 26-letter count array |
| 128 | [Longest Consecutive Sequence](leetcode-solutions/longest-consecutive-sequence/) | Medium | Put everything in a HashSet |
| 229 | [Majority Element II](leetcode-solutions/majority-element-ii/) | Medium | At most two such elements exist |
| 238 | [Product of Array Except Self](leetcode-solutions/product-of-array-except-self/) | Medium | answer[i] = (product of everything left of i) * (product of everything right of i) |
| 347 | [Top K Frequent Elements](leetcode-solutions/top-k-frequent-elements/) | Medium | Count with a map |
| 560 | [Subarray Sum Equals K](leetcode-solutions/subarray-sum-equals-k/) | Medium | Prefix sums: subarray (i, j] sums to k if prefix[j] - prefix[i] = k |
| 2364 | [Count Number of Bad Pairs](leetcode-solutions/count-number-of-bad-pairs/) (not accepted) | Medium | Rearrange: a pair is GOOD when nums[i] - i == nums[j] - j |

## Two Pointers (20)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 26 | [Remove Duplicates from Sorted Array](leetcode-solutions/remove-duplicates-from-sorted-array/) | Easy | Slow pointer i marks the last unique value; fast pointer j scans |
| 27 | [Remove Element](leetcode-solutions/remove-element/) (not accepted) | Easy | Write pointer k: for each element != val, copy it to nums[k++] |
| 28 | [Find the Index of the First Occurrence in a String](leetcode-solutions/find-the-index-of-the-first-occurrence-in-a-string/) | Easy | Brute force compares needle at each start: O(n*m) |
| 88 | [Merge Sorted Array](leetcode-solutions/merge-sorted-array/) | Easy | Fill from the back: compare the largest remaining of each array and write it at index m+n-1, moving backwards |
| 125 | [Valid Palindrome](leetcode-solutions/valid-palindrome/) | Easy | Two pointers from both ends, skipping non-alphanumerics and comparing lowercase characters |
| 283 | [Move Zeroes](leetcode-solutions/move-zeroes/) | Easy | Write pointer: for each non-zero element, swap it into position w and increment w |
| 344 | [Reverse String](leetcode-solutions/reverse-string/) | Easy | Swap from both ends moving inward. |
| 392 | [Is Subsequence](leetcode-solutions/is-subsequence/) | Easy | Two pointers: advance through t and move the s pointer whenever characters match |
| 5 | [Longest Palindromic Substring](leetcode-solutions/longest-palindromic-substring/) | Medium | Expand around each centre: 2n-1 centres (each character and each gap) |
| 11 | [Container With Most Water](leetcode-solutions/container-with-most-water/) | Medium | Two pointers from both ends |
| 15 | [3Sum](leetcode-solutions/3sum/) | Medium | Sort, fix the first element, then solve two-sum on the rest with two pointers |
| 18 | [4Sum](leetcode-solutions/4sum/) | Medium | Same idea as 3Sum with one more fixed loop: two nested loops + two pointers |
| 31 | [Next Permutation](leetcode-solutions/next-permutation/) | Medium | 1) From the right, find the first i with nums[i] < nums[i+1] (the pivot) |
| 75 | [Sort Colors](leetcode-solutions/sort-colors/) | Medium | Dutch national flag: pointers low, mid, high |
| 167 | [Two Sum II - Input Array Is Sorted](leetcode-solutions/two-sum-ii-input-array-is-sorted/) | Medium | Two pointers from both ends: if the sum is too big move right left, if too small move left right. |
| 189 | [Rotate Array](leetcode-solutions/rotate-array/) | Medium | k %= n, then three reversals: whole array, first k, last n-k |
| 443 | [String Compression](leetcode-solutions/string-compression/) | Medium | Read pointer scans runs; write pointer writes the char and then each digit of the count |
| 647 | [Palindromic Substrings](leetcode-solutions/palindromic-substrings/) | Medium | Expand around each of the 2n-1 centres; every successful expansion step is one more palindrome. |
| 2149 | [Rearrange Array Elements by Sign](leetcode-solutions/rearrange-array-elements-by-sign/) | Medium | Two write pointers into a new array: positives go to even indices (0, 2, ...), negatives to odd (1, 3, ...). |
| 42 | [Trapping Rain Water](leetcode-solutions/trapping-rain-water/) | Hard | Water at i = min(maxLeft[i], maxRight[i]) - h[i] |

## Sliding Window (7)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 121 | [Best Time to Buy and Sell Stock](leetcode-solutions/best-time-to-buy-and-sell-stock/) | Easy | Scan once, tracking the minimum price seen so far; the best profit when selling today is price - minSoFar. |
| 3456 | [Find Special Substring of Length K](leetcode-solutions/find-special-substring-of-length-k/) | Easy | Equivalent to: some maximal run of equal characters has length exactly k |
| 3 | [Longest Substring Without Repeating Characters](leetcode-solutions/longest-substring-without-repeating-characters/) | Medium | Sliding window with a set: extend right; on a repeat, shrink from the left until it's gone |
| 424 | [Longest Repeating Character Replacement](leetcode-solutions/longest-repeating-character-replacement/) | Medium | Sliding window: it's valid while windowLen - maxFreq <= k |
| 567 | [Permutation in String](leetcode-solutions/permutation-in-string/) | Medium | Fixed-size sliding window of length /s1/ with 26-letter counts |
| 76 | [Minimum Window Substring](leetcode-solutions/minimum-window-substring/) | Hard | Variable sliding window with counts |
| 239 | [Sliding Window Maximum](leetcode-solutions/sliding-window-maximum/) | Hard | Monotonic deque of indices with decreasing values |

## Stack & Monotonic Stack (9)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 20 | [Valid Parentheses](leetcode-solutions/valid-parentheses/) | Easy | Push openers onto a stack |
| 232 | [Implement Queue using Stacks](leetcode-solutions/implement-queue-using-stacks/) | Easy | Push onto an 'in' stack |
| 496 | [Next Greater Element I](leetcode-solutions/next-greater-element-i/) | Easy | Compute next-greater for all of nums2 with a monotonic stack (right to left), store it in a map value -> next greater, then look up each nums1 value. |
| 150 | [Evaluate Reverse Polish Notation](leetcode-solutions/evaluate-reverse-polish-notation/) | Medium | Push numbers onto a stack; on an operator pop b then a (order matters for - and /), push a op b. |
| 155 | [Min Stack](leetcode-solutions/min-stack/) | Medium | Store each element together with the minimum of the stack at the time it was pushed; getMin reads the top's stored minimum. |
| 503 | [Next Greater Element II](leetcode-solutions/next-greater-element-ii/) | Medium | Simulate two copies of the array: iterate i from 2n-1 down to 0 using nums[i % n] with a monotonic stack, and only record answers when i < n. |
| 739 | [Daily Temperatures](leetcode-solutions/daily-temperatures/) | Medium | Monotonic stack of indices (next greater element) |
| 853 | [Car Fleet](leetcode-solutions/car-fleet/) | Medium | Sort by position and walk from the car closest to target |
| 84 | [Largest Rectangle in Histogram](leetcode-solutions/largest-rectangle-in-histogram/) | Hard | Each bar's best rectangle extends to the previous and next smaller bars: area = h[i] * (nextSmaller - prevSmaller - 1) |

## Binary Search (13)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 35 | [Search Insert Position](leetcode-solutions/search-insert-position/) | Easy | This is the lower bound: the first index with nums[i] >= target |
| 69 | [Sqrt(x)](leetcode-solutions/sqrtx/) | Easy | Binary search for the largest m with m*m <= x |
| 704 | [Binary Search](leetcode-solutions/binary-search/) | Easy | Classic template: while (lo <= hi), mid = lo + (hi - lo) / 2 avoids overflow; move lo or hi past mid. |
| 33 | [Search in Rotated Sorted Array](leetcode-solutions/search-in-rotated-sorted-array/) | Medium | One half around mid is always sorted |
| 34 | [Find First and Last Position of Element in Sorted Array](leetcode-solutions/find-first-and-last-position-of-element-in-sorted-array/) | Medium | Run binary search twice |
| 74 | [Search a 2D Matrix](leetcode-solutions/search-a-2d-matrix/) | Medium | Treat it as one sorted array of length m*n: index k maps to row k / cols and column k % cols |
| 81 | [Search in Rotated Sorted Array II](leetcode-solutions/search-in-rotated-sorted-array-ii/) | Medium | When nums[lo] == nums[mid] == nums[hi] you can't tell which half is sorted, so shrink both ends by one |
| 153 | [Find Minimum in Rotated Sorted Array](leetcode-solutions/find-minimum-in-rotated-sorted-array/) | Medium | At each step one half is sorted |
| 162 | [Find Peak Element](leetcode-solutions/find-peak-element/) | Medium | If nums[mid] < nums[mid+1] you are on an uphill slope, so a peak must exist to the right; otherwise one exists at mid or to the left. |
| 540 | [Single Element in a Sorted Array](leetcode-solutions/single-element-in-a-sorted-array/) | Medium | Before the single element, pairs start at even indices; after it, at odd ones |
| 875 | [Koko Eating Bananas](leetcode-solutions/koko-eating-bananas/) | Medium | Binary search on the answer: speeds 1..max(pile) |
| 981 | [Time Based Key-Value Store](leetcode-solutions/time-based-key-value-store/) | Medium | Map key -> list of (timestamp, value), already sorted because timestamps only increase |
| 4 | [Median of Two Sorted Arrays](leetcode-solutions/median-of-two-sorted-arrays/) | Hard | Binary search the partition in the smaller array: take i from nums1 and half - i from nums2 |

## Linked List (18)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 21 | [Merge Two Sorted Lists](leetcode-solutions/merge-two-sorted-lists/) | Easy | Dummy head + tail pointer; attach the smaller head each step, then append whatever remains. |
| 141 | [Linked List Cycle](leetcode-solutions/linked-list-cycle/) | Easy | Floyd: slow moves 1, fast moves 2; if there's a cycle they meet, otherwise fast reaches null |
| 160 | [Intersection of Two Linked Lists](leetcode-solutions/intersection-of-two-linked-lists/) | Easy | HashSet of nodes from list A works in O(n) space |
| 206 | [Reverse Linked List](leetcode-solutions/reverse-linked-list/) | Easy | Iterative three-pointer pattern: save next, point curr.next to prev, advance prev and curr |
| 234 | [Palindrome Linked List](leetcode-solutions/palindrome-linked-list/) | Easy | O(1) space: find the middle with slow/fast pointers, reverse the second half, and compare it with the first half node by node. |
| 876 | [Middle of the Linked List](leetcode-solutions/middle-of-the-linked-list/) | Easy | Slow/fast pointers: when fast reaches the end, slow is at the middle. |
| 2 | [Add Two Numbers](leetcode-solutions/add-two-numbers/) | Medium | Walk both lists together with a carry, treating a finished list as 0 |
| 19 | [Remove Nth Node From End of List](leetcode-solutions/remove-nth-node-from-end-of-list/) | Medium | One pass: move a fast pointer n steps ahead, then move fast and slow together until fast reaches the last node; slow is just before the target |
| 138 | [Copy List with Random Pointer](leetcode-solutions/copy-list-with-random-pointer/) | Medium | Pass 1: create a clone for every node in a map old -> new |
| 142 | [Linked List Cycle II](leetcode-solutions/linked-list-cycle-ii/) | Medium | After slow and fast meet, reset slow to head and move both one step at a time; they meet at the cycle start |
| 143 | [Reorder List](leetcode-solutions/reorder-list/) | Medium | Three classic steps: find the middle (slow/fast), reverse the second half, then merge the two halves alternately. |
| 146 | [LRU Cache](leetcode-solutions/lru-cache/) | Medium | HashMap key -> node plus a doubly linked list ordered by recency, with dummy head and tail |
| 148 | [Sort List](leetcode-solutions/sort-list/) | Medium | Merge sort: split at the middle with slow/fast (fast starts at head.next so the split is balanced), sort both halves recursively, and merge the two sorted lists. |
| 237 | [Delete Node in a Linked List](leetcode-solutions/delete-node-in-a-linked-list/) | Medium | You can't reach the previous node, so copy the next node's value into this node and unlink the next node: node.val = node.next.val; node.next = node.next.next |
| 287 | [Find the Duplicate Number](leetcode-solutions/find-the-duplicate-number/) | Medium | Treat i -> nums[i] as a linked list; the duplicate is where a cycle starts |
| 328 | [Odd Even Linked List](leetcode-solutions/odd-even-linked-list/) | Medium | Keep two chains (odd and even) and remember evenHead |
| 725 | [Split Linked List in Parts](leetcode-solutions/split-linked-list-in-parts/) | Medium | Count the length L |
| 25 | [Reverse Nodes in k-Group](leetcode-solutions/reverse-nodes-in-k-group/) | Hard | Loop: find the kth node from the current group start (stop if missing) |

## Trees (31)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 94 | [Binary Tree Inorder Traversal](leetcode-solutions/binary-tree-inorder-traversal/) | Easy | Iterative version: push all left children onto a stack, pop one, visit it, then move to its right child. |
| 100 | [Same Tree](leetcode-solutions/same-tree/) | Easy | Both null -> true; one null or values differ -> false; otherwise recurse on left and right. |
| 101 | [Symmetric Tree](leetcode-solutions/symmetric-tree/) | Easy | Compare the left and right subtrees as mirrors: values equal, left.left vs right.right, and left.right vs right.left. |
| 104 | [Maximum Depth of Binary Tree](leetcode-solutions/maximum-depth-of-binary-tree/) | Easy | depth(node) = 1 + max(depth(left), depth(right)) |
| 108 | [Convert Sorted Array to Binary Search Tree](leetcode-solutions/convert-sorted-array-to-binary-search-tree/) | Easy | Make the middle element the root and recurse on the left and right halves; this keeps the tree balanced. |
| 110 | [Balanced Binary Tree](leetcode-solutions/balanced-binary-tree/) | Easy | Compute heights bottom-up (post-order) and check the balance condition in the same pass, so it runs in O(n) instead of O(n^2). |
| 144 | [Binary Tree Preorder Traversal](leetcode-solutions/binary-tree-preorder-traversal/) | Easy | Iteratively: pop from a stack, visit, push right child then left child (so left is processed first). |
| 145 | [Binary Tree Postorder Traversal](leetcode-solutions/binary-tree-postorder-traversal/) | Easy | Recursive DFS: visit children first, then the node |
| 226 | [Invert Binary Tree](leetcode-solutions/invert-binary-tree/) | Easy | Swap children at each node and recurse |
| 404 | [Sum of Left Leaves](leetcode-solutions/sum-of-left-leaves/) | Easy | DFS passing an isLeft flag; add the value when the node is a leaf and isLeft is true. |
| 543 | [Diameter of Binary Tree](leetcode-solutions/diameter-of-binary-tree/) | Easy | While computing heights bottom-up, the longest path bending at a node is leftHeight + rightHeight; keep the maximum in a global variable. |
| 572 | [Subtree of Another Tree](leetcode-solutions/subtree-of-another-tree/) | Easy | At every node of root, run isSameTree(node, subRoot) |
| 98 | [Validate Binary Search Tree](leetcode-solutions/validate-binary-search-tree/) | Medium | Pass down an allowed (min, max) range; every node must lie strictly inside it |
| 102 | [Binary Tree Level Order Traversal](leetcode-solutions/binary-tree-level-order-traversal/) | Medium | BFS with a queue; read q.size() at the start of each level so you know how many nodes belong to it. |
| 103 | [Binary Tree Zigzag Level Order Traversal](leetcode-solutions/binary-tree-zigzag-level-order-traversal/) | Medium | Normal BFS; on odd levels insert each value at the front of the level list (or reverse the list) instead of changing the traversal order. |
| 105 | [Construct Binary Tree from Preorder and Inorder Traversal](leetcode-solutions/construct-binary-tree-from-preorder-and-inorder-traversal/) | Medium | preorder[preStart] is the root; find it in inorder with a HashMap |
| 106 | [Construct Binary Tree from Inorder and Postorder Traversal](leetcode-solutions/construct-binary-tree-from-inorder-and-postorder-traversal/) | Medium | The last postorder element is the root |
| 116 | [Populating Next Right Pointers in Each Node](leetcode-solutions/populating-next-right-pointers-in-each-node/) | Medium | BFS by levels works with O(n) space |
| 199 | [Binary Tree Right Side View](leetcode-solutions/binary-tree-right-side-view/) | Medium | Level-order BFS and record the last node of each level |
| 222 | [Count Complete Tree Nodes](leetcode-solutions/count-complete-tree-nodes/) | Medium | Simple DFS count is O(n) |
| 230 | [Kth Smallest Element in a BST](leetcode-solutions/kth-smallest-element-in-a-bst/) | Medium | Inorder traversal of a BST visits values in sorted order |
| 235 | [Lowest Common Ancestor of a Binary Search Tree](leetcode-solutions/lowest-common-ancestor-of-a-binary-search-tree/) | Medium | Use the BST order: if both values are smaller go left, if both are larger go right; otherwise the current node is where they split, so it's the LCA. |
| 236 | [Lowest Common Ancestor of a Binary Tree](leetcode-solutions/lowest-common-ancestor-of-a-binary-tree/) | Medium | Return the node if it's null, p or q |
| 337 | [House Robber III](leetcode-solutions/house-robber-iii/) | Medium | DP on trees: each DFS returns a pair (best if this node is robbed, best if it is not) |
| 863 | [All Nodes Distance K in Binary Tree](leetcode-solutions/all-nodes-distance-k-in-binary-tree/) | Medium | A tree is just an undirected graph once you can go upward: record each node's parent, then BFS from the target for k levels with a visited set. |
| 1448 | [Count Good Nodes in Binary Tree](leetcode-solutions/count-good-nodes-in-binary-tree/) | Medium | DFS passing down the maximum value seen on the path so far; a node is good if node.val >= that max. |
| 2096 | [Step-By-Step Directions From a Binary Tree Node to Another](leetcode-solutions/step-by-step-directions-from-a-binary-tree-node-to-another/) (not accepted) | Medium | Find root->start and root->dest paths as L/R strings (DFS with backtracking) |
| 2385 | [Amount of Time for Binary Tree to Be Infected](leetcode-solutions/amount-of-time-for-binary-tree-to-be-infected/) | Medium | Same trick as 'distance K': build parent pointers, BFS from start; the answer is the number of BFS levels minus one. |
| 124 | [Binary Tree Maximum Path Sum](leetcode-solutions/binary-tree-maximum-path-sum/) | Hard | DFS returns the best downward path starting at a node (node + max(0, left, right)); at each node update the global answer with node + max(0,left) + max(0,right), the path that bends there. |
| 297 | [Serialize and Deserialize Binary Tree](leetcode-solutions/serialize-and-deserialize-binary-tree/) | Hard | Level-order: write values with a null marker for missing children |
| 987 | [Vertical Order Traversal of a Binary Tree](leetcode-solutions/vertical-order-traversal-of-a-binary-tree/) | Hard | BFS or DFS recording (col, row, val) |

## Tries (2)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 208 | [Implement Trie (Prefix Tree)](leetcode-solutions/implement-trie-prefix-tree/) | Medium | Each node has 26 child links and an end-of-word flag |
| 212 | [Word Search II](leetcode-solutions/word-search-ii/) | Hard | Insert all words into a trie, then DFS from every cell, moving down the trie in step with the path |

## Heap / Priority Queue (9)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 703 | [Kth Largest Element in a Stream](leetcode-solutions/kth-largest-element-in-a-stream/) | Easy | Keep a min-heap of size k: it holds the k largest values and the top is the kth largest |
| 1046 | [Last Stone Weight](leetcode-solutions/last-stone-weight/) | Easy | Max-heap: poll two, push the difference if it's non-zero. |
| 215 | [Kth Largest Element in an Array](leetcode-solutions/kth-largest-element-in-an-array/) | Medium | Size-k min-heap: O(n log k) |
| 355 | [Design Twitter](leetcode-solutions/design-twitter/) | Medium | Store each user's tweets newest-first with a global timestamp |
| 621 | [Task Scheduler](leetcode-solutions/task-scheduler/) | Medium | Simulate with a max-heap of remaining counts and a cooldown queue of (count, readyTime): always run the most frequent available task |
| 973 | [K Closest Points to Origin](leetcode-solutions/k-closest-points-to-origin/) | Medium | Compare squared distances (no sqrt) |
| 1792 | [Maximum Average Pass Ratio](leetcode-solutions/maximum-average-pass-ratio/) | Medium | Greedy with a max-heap ordered by the gain (p+1)/(t+1) - p/t |
| 23 | [Merge k Sorted Lists](leetcode-solutions/merge-k-sorted-lists/) | Hard | Min-heap of the k list heads: pop the smallest, append it, push its next node |
| 295 | [Find Median from Data Stream](leetcode-solutions/find-median-from-data-stream/) | Hard | Two heaps: a max-heap for the smaller half and a min-heap for the larger half |

## Backtracking (11)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 17 | [Letter Combinations of a Phone Number](leetcode-solutions/letter-combinations-of-a-phone-number/) | Medium | Backtracking: at index i, loop over the letters of digits[i], append one, recurse to i+1, then remove it. |
| 22 | [Generate Parentheses](leetcode-solutions/generate-parentheses/) | Medium | Backtrack on counts: add '(' while open < n, add ')' while close < open |
| 39 | [Combination Sum](leetcode-solutions/combination-sum/) | Medium | Backtracking with 'take (stay on same index)' or 'skip (move to next index)' |
| 40 | [Combination Sum II](leetcode-solutions/combination-sum-ii/) | Medium | Sort, then in the for-loop skip candidates[k] == candidates[k-1] when k > start: the same value is never chosen twice at the same depth |
| 46 | [Permutations](leetcode-solutions/permutations/) | Medium | Backtracking: at each level pick any unused number (a boolean[] or set of used values), recurse, then un-pick it |
| 78 | [Subsets](leetcode-solutions/subsets/) | Medium | For each element choose take or skip (2^n leaves) |
| 79 | [Word Search](leetcode-solutions/word-search/) | Medium | DFS backtracking from each matching start cell |
| 90 | [Subsets II](leetcode-solutions/subsets-ii/) | Medium | Sort first |
| 131 | [Palindrome Partitioning](leetcode-solutions/palindrome-partitioning/) | Medium | Backtracking: from index start, try every end where s[start..end] is a palindrome, add it, and recurse from end+1. |
| 37 | [Sudoku Solver](leetcode-solutions/sudoku-solver/) | Hard | Backtracking: find the next empty cell, try 1-9 if valid in its row, column and 3x3 box, recurse, and undo on failure |
| 51 | [N-Queens](leetcode-solutions/n-queens/) | Hard | Place one queen per column with backtracking |

## Graphs: BFS / DFS (10)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 463 | [Island Perimeter](leetcode-solutions/island-perimeter/) | Easy | Each land cell contributes 4 minus its number of land neighbours, so a plain double loop is enough |
| 130 | [Surrounded Regions](leetcode-solutions/surrounded-regions/) | Medium | Reverse thinking: DFS from every border 'O' and mark it safe |
| 133 | [Clone Graph](leetcode-solutions/clone-graph/) | Medium | DFS with a map original -> clone |
| 200 | [Number of Islands](leetcode-solutions/number-of-islands/) | Medium | Scan the grid; each unvisited land cell starts a new island |
| 417 | [Pacific Atlantic Water Flow](leetcode-solutions/pacific-atlantic-water-flow/) | Medium | Reverse the flow: DFS uphill from every Pacific border cell and from every Atlantic border cell, marking what each ocean can reach |
| 695 | [Max Area of Island](leetcode-solutions/max-area-of-island/) | Medium | Flood-fill each unvisited land cell (DFS or BFS) and count the cells reached; keep the maximum. |
| 785 | [Is Graph Bipartite?](leetcode-solutions/is-graph-bipartite/) | Medium | Two-colour the graph with BFS or DFS: give neighbours the opposite colour |
| 994 | [Rotting Oranges](leetcode-solutions/rotting-oranges/) | Medium | Multi-source BFS: put every initially rotten orange in the queue at time 0 |
| 1091 | [Shortest Path in Binary Matrix](leetcode-solutions/shortest-path-in-binary-matrix/) | Medium | Unweighted shortest path means BFS |
| 815 | [Bus Routes](leetcode-solutions/bus-routes/) | Hard | BFS over buses, not stops |

## Advanced Graphs (11)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 207 | [Course Schedule](leetcode-solutions/course-schedule/) | Medium | It's possible exactly when the prerequisite graph has no cycle |
| 210 | [Course Schedule II](leetcode-solutions/course-schedule-ii/) | Medium | Kahn's algorithm: the order nodes leave the queue is a topological order |
| 684 | [Redundant Connection](leetcode-solutions/redundant-connection/) | Medium | Union-find: process edges in order |
| 743 | [Network Delay Time](leetcode-solutions/network-delay-time/) | Medium | Single-source shortest paths with non-negative weights: Dijkstra with a min-heap |
| 787 | [Cheapest Flights Within K Stops](leetcode-solutions/cheapest-flights-within-k-stops/) | Medium | Plain Dijkstra fails because a cheaper path may use too many stops |
| 802 | [Find Eventual Safe States](leetcode-solutions/find-eventual-safe-states/) | Medium | Reverse every edge; terminal nodes now have in-degree 0 |
| 947 | [Most Stones Removed with Same Row or Column](leetcode-solutions/most-stones-removed-with-same-row-or-column/) | Medium | Stones sharing a row or column form connected components, and each component can be reduced to one stone |
| 1319 | [Number of Operations to Make Network Connected](leetcode-solutions/number-of-operations-to-make-network-connected/) | Medium | Union-find: every edge joining two already-connected nodes is a spare cable |
| 1584 | [Min Cost to Connect All Points](leetcode-solutions/min-cost-to-connect-all-points/) | Medium | Minimum spanning tree |
| 127 | [Word Ladder](leetcode-solutions/word-ladder/) | Hard | BFS over words |
| 778 | [Swim in Rising Water](leetcode-solutions/swim-in-rising-water/) | Hard | Minimise the maximum elevation along a path: Dijkstra-like search with a min-heap keyed by the max height so far |

## 1-D Dynamic Programming (12)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 70 | [Climbing Stairs](leetcode-solutions/climbing-stairs/) | Easy | ways(n) = ways(n-1) + ways(n-2): it's Fibonacci |
| 118 | [Pascal's Triangle](leetcode-solutions/pascals-triangle/) | Easy | Each inner entry is the sum of the two above it: row[j] = prev[j-1] + prev[j] |
| 509 | [Fibonacci Number](leetcode-solutions/fibonacci-number/) | Easy | Plain recursion is O(2^n) because subproblems repeat |
| 746 | [Min Cost Climbing Stairs](leetcode-solutions/min-cost-climbing-stairs/) | Easy | f(i) = min(f(i-1) + cost[i-1], f(i-2) + cost[i-2]) with f(0) = f(1) = 0. |
| 53 | [Maximum Subarray](leetcode-solutions/maximum-subarray/) | Medium | Kadane's algorithm: keep a running sum, record the max, and reset the sum to 0 when it goes negative (a negative prefix only hurts). |
| 91 | [Decode Ways](leetcode-solutions/decode-ways/) | Medium | ways(i) = ways(i+1) if s[i] != '0', plus ways(i+2) if s[i..i+1] is between 10 and 26 |
| 139 | [Word Break](leetcode-solutions/word-break/) | Medium | dp[i] = true if some word matches s starting at i and dp[i + len] is true; dp[n] = true |
| 152 | [Maximum Product Subarray](leetcode-solutions/maximum-product-subarray/) | Medium | A negative number flips max and min, so track both the max and min product ending here |
| 198 | [House Robber](leetcode-solutions/house-robber/) | Medium | dp[i] = max(nums[i] + dp[i-2] (rob it), dp[i-1] (skip it)) |
| 213 | [House Robber II](leetcode-solutions/house-robber-ii/) | Medium | You can't take both the first and last house, so answer = max(rob(nums[0..n-2]), rob(nums[1..n-1])) using the linear House Robber. |
| 300 | [Longest Increasing Subsequence](leetcode-solutions/longest-increasing-subsequence/) | Medium | DP over (index, previous index): take nums[i] if it's larger than the previous, or skip it |
| 322 | [Coin Change](leetcode-solutions/coin-change/) | Medium | Unbounded knapsack: for coin i either skip it (i-1) or take it and stay at i |

## 2-D Dynamic Programming (15)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 62 | [Unique Paths](leetcode-solutions/unique-paths/) | Medium | paths(i, j) = paths(i-1, j) + paths(i, j-1), with the first row and column all 1 |
| 63 | [Unique Paths II](leetcode-solutions/unique-paths-ii/) | Medium | Same recurrence, but an obstacle cell has 0 paths |
| 64 | [Minimum Path Sum](leetcode-solutions/minimum-path-sum/) | Medium | dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1]) |
| 72 | [Edit Distance](leetcode-solutions/edit-distance/) | Medium | f(i, j): if chars match, f(i-1, j-1); else 1 + min(insert f(i, j-1), delete f(i-1, j), replace f(i-1, j-1)) |
| 120 | [Triangle](leetcode-solutions/triangle/) | Medium | Go bottom-up: dp[j] = tri[i][j] + min(dp[j], dp[j+1]) starting from the last row |
| 416 | [Partition Equal Subset Sum](leetcode-solutions/partition-equal-subset-sum/) | Medium | If the total is odd, it's impossible |
| 494 | [Target Sum](leetcode-solutions/target-sum/) | Medium | Memoise (index, running sum) |
| 516 | [Longest Palindromic Subsequence](leetcode-solutions/longest-palindromic-subsequence/) | Medium | A palindromic subsequence reads the same reversed, so the answer = LCS(s, reverse(s)). |
| 518 | [Coin Change II](leetcode-solutions/coin-change-ii/) | Medium | Counting version of unbounded knapsack: ways(i, a) = ways(i-1, a) + ways(i, a - coins[i]) |
| 583 | [Delete Operation for Two Strings](leetcode-solutions/delete-operation-for-two-strings/) | Medium | Whatever survives is a common subsequence, so keep the longest one: answer = len1 + len2 - 2 * LCS. |
| 931 | [Minimum Falling Path Sum](leetcode-solutions/minimum-falling-path-sum/) | Medium | dp[i][j] = matrix[i][j] + min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]) |
| 1143 | [Longest Common Subsequence](leetcode-solutions/longest-common-subsequence/) | Medium | f(i, j) = 1 + f(i-1, j-1) if chars match, else max(f(i-1, j), f(i, j-1)) |
| 115 | [Distinct Subsequences](leetcode-solutions/distinct-subsequences/) | Hard | f(i, j) = ways using s[0..i) to form t[0..j) |
| 1092 | [Shortest Common Supersequence ](leetcode-solutions/shortest-common-supersequence/) | Hard | Build the LCS table, then walk back from (n, m): on a match emit the character once; otherwise emit the character from the side you step away from |
| 1312 | [Minimum Insertion Steps to Make a String Palindrome](leetcode-solutions/minimum-insertion-steps-to-make-a-string-palindrome/) | Hard | Keep the longest palindromic subsequence and insert a partner for every other character: answer = n - LPS = n - LCS(s, reverse(s)). |

## Greedy (11)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 3014 | [Minimum Number of Pushes to Type Word I](leetcode-solutions/minimum-number-of-pushes-to-type-word-i/) | Easy | 8 keys: the first 8 letters cost 1 push each, the next 8 cost 2, and so on |
| 45 | [Jump Game II](leetcode-solutions/jump-game-ii/) | Medium | BFS by windows: [l, r] are the indices reachable with 'jumps' jumps; the next window ends at the farthest i + nums[i] from the current window. |
| 55 | [Jump Game](leetcode-solutions/jump-game/) | Medium | Walk backwards keeping a 'goal': if i + nums[i] >= goal, then i can reach it and becomes the new goal |
| 122 | [Best Time to Buy and Sell Stock II](leetcode-solutions/best-time-to-buy-and-sell-stock-ii/) | Medium | Greedy: every upward step prices[i+1] > prices[i] can be captured, so sum all positive day-to-day differences. |
| 134 | [Gas Station](leetcode-solutions/gas-station/) | Medium | If total gas < total cost, it's impossible |
| 678 | [Valid Parenthesis String](leetcode-solutions/valid-parenthesis-string/) (not accepted) | Medium | Greedy range: track the min and max possible number of open brackets |
| 763 | [Partition Labels](leetcode-solutions/partition-labels/) | Medium | Record each letter's last index |
| 846 | [Hand of Straights](leetcode-solutions/hand-of-straights/) | Medium | The smallest remaining card must start a group |
| 1899 | [Merge Triplets to Form Target Triplet](leetcode-solutions/merge-triplets-to-form-target-triplet/) | Medium | Ignore any triplet with a value larger than the target in some position (it would overshoot) |
| 3457 | [Eat Pizzas!](leetcode-solutions/eat-pizzas/) | Medium | Sort |
| 135 | [Candy](leetcode-solutions/candy/) | Hard | Two passes: left-to-right satisfies the left neighbour rule, right-to-left satisfies the right one; each child gets the max of the two requirements. |

## Intervals (3)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 56 | [Merge Intervals](leetcode-solutions/merge-intervals/) | Medium | Sort by start |
| 57 | [Insert Interval](leetcode-solutions/insert-interval/) | Medium | Three phases in one pass: copy intervals ending before the new one starts; merge all that overlap it (min start, max end); copy the rest. |
| 435 | [Non-overlapping Intervals](leetcode-solutions/non-overlapping-intervals/) | Medium | Greedy: sort by start; on overlap, remove one and keep the interval with the smaller end (it leaves more room) |

## Math & Geometry / Matrix (14)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 9 | [Palindrome Number](leetcode-solutions/palindrome-number/) | Easy | Reverse the digits arithmetically (rev = rev*10 + x%10) and compare |
| 13 | [Roman to Integer](leetcode-solutions/roman-to-integer/) | Easy | Scan left to right: if a symbol is smaller than the one after it (IV, IX, XL, ...), subtract it; otherwise add it. |
| 66 | [Plus One](leetcode-solutions/plus-one/) | Easy | From the right: if a digit is < 9, increment it and return |
| 171 | [Excel Sheet Column Number](leetcode-solutions/excel-sheet-column-number/) | Easy | It's base-26 with digits 1..26: result = result * 26 + (c - 'A' + 1), scanning left to right. |
| 202 | [Happy Number](leetcode-solutions/happy-number/) | Easy | Either it reaches 1 or enters a cycle |
| 326 | [Power of Three](leetcode-solutions/power-of-three/) | Easy | Divide by 3 while divisible and check whether you reach 1 |
| 412 | [Fizz Buzz](leetcode-solutions/fizz-buzz/) | Easy | Check the combined case (3 and 5) first. |
| 7 | [Reverse Integer](leetcode-solutions/reverse-integer/) | Medium | Pop digits with % 10 and push with result*10 + digit |
| 8 | [String to Integer (atoi)](leetcode-solutions/string-to-integer-atoi/) | Medium | A careful state walk |
| 48 | [Rotate Image](leetcode-solutions/rotate-image/) | Medium | Clockwise rotation = transpose (swap m[i][j] with m[j][i] for j > i), then reverse each row. |
| 54 | [Spiral Matrix](leetcode-solutions/spiral-matrix/) | Medium | Keep four boundaries (top, bottom, left, right) |
| 73 | [Set Matrix Zeroes](leetcode-solutions/set-matrix-zeroes/) | Medium | O(m+n) space: separate row and column flag arrays |
| 3021 | [Alice and Bob Playing Flower Game](leetcode-solutions/alice-and-bob-playing-flower-game/) | Medium | Alice wins exactly when x + y is odd, i.e |
| 3070 | [Count Submatrices with Top-Left Element and Sum Less Than k](leetcode-solutions/count-submatrices-with-top-left-element-and-sum-less-than-k/) (not accepted) | Medium | Every such submatrix is a prefix rectangle (0,0)..(i,j) |

## Bit Manipulation (6)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 136 | [Single Number](leetcode-solutions/single-number/) | Easy | XOR everything: x ^ x = 0 and x ^ 0 = x, so pairs cancel and the single value remains. |
| 190 | [Reverse Bits](leetcode-solutions/reverse-bits/) | Easy | 32 times: result = (result << 1) / (n & 1); n >>>= 1 |
| 191 | [Number of 1 Bits](leetcode-solutions/number-of-1-bits/) | Easy | Check each of the 32 bits with a mask |
| 268 | [Missing Number](leetcode-solutions/missing-number/) | Easy | XOR all indices 0..n with all values; pairs cancel (x ^ x = 0), leaving the missing number |
| 1863 | [Sum of All Subset XOR Totals](leetcode-solutions/sum-of-all-subset-xor-totals/) | Easy | Enumerate all 2^n masks and XOR the chosen elements |
| 260 | [Single Number III](leetcode-solutions/single-number-iii/) | Medium | XOR all gives a ^ b (non-zero) |

## SQL (13)

| # | Problem | Difficulty | Key idea |
|---|---|---|---|
| 182 | [Duplicate Emails](leetcode-solutions/duplicate-emails/) | Easy | GROUP BY email HAVING COUNT(*) > 1 |
| 197 | [Rising Temperature](leetcode-solutions/rising-temperature/) | Easy | Self-join Weather on DATEDIFF(w2.recordDate, w1.recordDate) = 1 and compare temperatures |
| 584 | [Find Customer Referee](leetcode-solutions/find-customer-referee/) | Easy | NULL != 2 evaluates to UNKNOWN, not TRUE, so you must add 'OR referee_id IS NULL' explicitly. |
| 586 | [Customer Placing the Largest Number of Orders](leetcode-solutions/customer-placing-the-largest-number-of-orders/) | Easy | GROUP BY customer, ORDER BY COUNT(*) DESC, LIMIT 1. |
| 595 | [Big Countries](leetcode-solutions/big-countries/) | Easy | Simple WHERE with OR |
| 1068 | [Product Sales Analysis I](leetcode-solutions/product-sales-analysis-i/) | Easy | INNER JOIN Sales and Product on product_id, then select the needed columns. |
| 1148 | [Article Views I](leetcode-solutions/article-views-i/) | Easy | Filter author_id = viewer_id, use DISTINCT to remove duplicates, alias the column and ORDER BY. |
| 1378 | [Replace Employee ID With The Unique Identifier](leetcode-solutions/replace-employee-id-with-the-unique-identifier/) | Easy | LEFT JOIN keeps every employee even when there's no matching EmployeeUNI row. |
| 1581 | [Customer Who Visited but Did Not Make Any Transactions](leetcode-solutions/customer-who-visited-but-did-not-make-any-transactions/) | Easy | Keep visits whose visit_id is NOT IN the Transactions table (or LEFT JOIN and test for NULL), then GROUP BY customer. |
| 1661 | [Average Time of Process per Machine](leetcode-solutions/average-time-of-process-per-machine/) | Easy | Self-join the table: one alias for 'start' rows and one for 'end' rows on the same machine+process, then GROUP BY machine and AVG the difference. |
| 1683 | [Invalid Tweets](leetcode-solutions/invalid-tweets/) | Easy | WHERE LENGTH(content) > 15 |
| 1757 | [Recyclable and Low Fat Products](leetcode-solutions/recyclable-and-low-fat-products/) | Easy | Simple WHERE with AND. |
| 176 | [Second Highest Salary](leetcode-solutions/second-highest-salary/) | Medium | MAX(salary) WHERE salary < (SELECT MAX(salary)) |
