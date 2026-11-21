/*
 * 110. Balanced Binary Tree  [Easy]
 * https://leetcode.com/problems/balanced-binary-tree/
 * Topics: Tree, Depth-First Search, Binary Tree
 *
 * Problem:     Decide whether a binary tree is height-balanced: at every node the heights
 *              of the left and right subtrees differ by at most 1.
 * Example:     [3,9,20,null,null,15,7] -> true; [1,2,2,3,3,null,null,4,4] -> false
 * Constraints: 0..5000 nodes
 *
 * Key idea:    Compute heights bottom-up (post-order) and check the balance condition in
 *              the same pass, so it runs in O(n) instead of O(n^2).
 *
 * Approach:    Post-order height with a global flag
 * Complexity:  time O(n), space O(h)
 * Also see:    _2: Post-order returning (height, isBalanced) record
 * Submitted:   2026-01-18 (submission 1888830369, AC)
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
    private boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true; 
        isBalanced = true; 

        computeHeight(root);
        return isBalanced; 
    }

    private int computeHeight(TreeNode root){
        if(root == null) return 0; 
        int leftSubTreeHeight = computeHeight(root.left);
        int rightSubTreeHeight = computeHeight(root.right);

        if(Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
            isBalanced = false; 
        }

        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);

    }


}