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
 * Approach:    Post-order returning (height, isBalanced) record
 * Complexity:  time O(n), space O(h)
 * Also see:    _1: Post-order height with a global flag
 * Submitted:   2024-02-04 (submission 1166038476, AC)
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
    private boolean isBalanced = true; 

    public boolean isBalanced(TreeNode root) {
        return findHeight(root).isBalanced; 
    }

    public HeightAndIsBalanced findHeight(TreeNode root){
        if(root == null) return new HeightAndIsBalanced(0,true); 
        HeightAndIsBalanced leftSubTree = findHeight(root.left);
        HeightAndIsBalanced rightSubTree = findHeight(root.right);
        int height = 1 + Math.max(leftSubTree.height,rightSubTree.height); 
        boolean isBalanced = Math.abs(leftSubTree.height - rightSubTree.height) <= 1  && leftSubTree.isBalanced && rightSubTree.isBalanced ; 
        return new HeightAndIsBalanced(height,isBalanced); 
    }

    record HeightAndIsBalanced(int height, boolean isBalanced){

    }
}