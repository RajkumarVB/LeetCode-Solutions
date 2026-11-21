/*
 * 100. Same Tree  [Easy]
 * https://leetcode.com/problems/same-tree/
 * Topics: Tree, Depth-First Search, Breadth-First Search, Binary Tree
 *
 * Problem:     Return whether two binary trees are structurally identical with equal
 *              values.
 * Example:     [1,2,3] and [1,2,3] -> true
 * Constraints: <= 100 nodes
 *
 * Key idea:    Both null -> true; one null or values differ -> false; otherwise recurse on
 *              left and right.
 *
 * Approach:    Recursive simultaneous DFS
 * Complexity:  time O(n), space O(h)
 * Submitted:   2026-01-18 (submission 1888833416, AC)
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true; 
        if(p == null && q != null) return false; 
        if(p != null && q == null) return false; 

        if(p.val != q.val) return false; 

        boolean isLeftSubTreeSame = isSameTree(p.left, q.left); 
        boolean isRightSubTreeSame = isSameTree(p.right, q.right); 
        return isLeftSubTreeSame && isRightSubTreeSame; 
    }
}