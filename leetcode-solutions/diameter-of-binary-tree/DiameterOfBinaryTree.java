/*
 * 543. Diameter of Binary Tree  [Easy]
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * Topics: Tree, Depth-First Search, Binary Tree, DP on Trees
 *
 * Problem:     Return the number of edges on the longest path between any two nodes of a
 *              binary tree.
 * Example:     [1,2,3,4,5] -> 3
 * Constraints: <= 1e4 nodes
 *
 * Key idea:    While computing heights bottom-up, the longest path bending at a node is
 *              leftHeight + rightHeight; keep the maximum in a global variable.
 *
 * Approach:    Post-order height + global max
 * Complexity:  time O(n), space O(h)
 * Submitted:   2026-01-18 (submission 1888827877, AC)
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

    private int diameter; 
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        diameter = 0; 
        computeHeight(root);
        return diameter; 
    }

    private int computeHeight(TreeNode root){
        if(root == null) return 0; 
        int leftSubTreeHeight = computeHeight(root.left);
        int rightSubTreeHeight = computeHeight(root.right);

        diameter = Math.max(diameter, leftSubTreeHeight + rightSubTreeHeight);
        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
    }
}