/*
 * 104. Maximum Depth of Binary Tree  [Easy]
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Topics: Tree, Depth-First Search, Breadth-First Search, Binary Tree
 *
 * Problem:     Return the number of nodes on the longest root-to-leaf path.
 * Example:     [3,9,20,null,null,15,7] -> 3
 * Constraints: <= 1e4 nodes
 *
 * Key idea:    depth(node) = 1 + max(depth(left), depth(right)). BFS counting levels also
 *              works.
 *
 * Approach:    Recursive DFS (bottom-up)
 * Complexity:  time O(n), space O(h)
 * Also see:    _2: BFS counting levels; _3: Top-down DFS passing depth
 * Submitted:   2025-03-31 (submission 1591794650, AC)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; 
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right)); 
    }
}