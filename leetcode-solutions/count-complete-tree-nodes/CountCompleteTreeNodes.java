/*
 * 222. Count Complete Tree Nodes  [Medium]
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * Topics: Binary Search, Bit Manipulation, Tree, Binary Tree
 *
 * Problem:     Count the nodes in a complete binary tree, ideally faster than O(n).
 * Example:     [1,2,3,4,5,6] -> 6
 * Constraints: <= 5e4 nodes
 *
 * Key idea:    Simple DFS count is O(n). Faster: if the leftmost and rightmost depths are
 *              equal the subtree is perfect, so it has 2^h - 1 nodes; otherwise recurse.
 *              That gives O(log^2 n).
 *
 * Approach:    Recursive count
 * Complexity:  time O(n), space O(log n)
 * Submitted:   2023-12-26 (submission 1128611170, AC)
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
    public int countNodes(TreeNode root) {
        if(root == null) return 0; 
        int leftSubTreeNoes = countNodes(root.left);
        int rightSubTreeNoes = countNodes(root.right); 
        return 1 + leftSubTreeNoes + rightSubTreeNoes; 
    }
}