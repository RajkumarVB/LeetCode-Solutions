/*
 * 101. Symmetric Tree  [Easy]
 * https://leetcode.com/problems/symmetric-tree/
 * Topics: Tree, Depth-First Search, Breadth-First Search, Binary Tree
 *
 * Problem:     Return whether a binary tree is a mirror image of itself.
 * Example:     [1,2,2,3,4,4,3] -> true
 * Constraints: <= 1000 nodes
 *
 * Key idea:    Compare the left and right subtrees as mirrors: values equal, left.left vs
 *              right.right, and left.right vs right.left.
 *
 * Approach:    Recursive mirror comparison
 * Complexity:  time O(n), space O(h)
 * Submitted:   2023-12-26 (submission 1128969447, AC)
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true; 
        return isSubTreeSymmetric(root.left, root.right); 
    }
    public static boolean isSubTreeSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true; 
        if(left == null || right == null) return false; 
        if(left.val != right.val) return false; 
        return (isSubTreeSymmetric(left.left, right.right) && isSubTreeSymmetric(left.right, right.left)); 
    }
}