/*
 * 98. Validate Binary Search Tree  [Medium]
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Topics: Tree, Depth-First Search, Binary Search Tree, Binary Tree
 *
 * Problem:     Return whether a binary tree is a valid BST (strict ordering).
 * Example:     [2,1,3] -> true; [5,1,4,null,null,3,6] -> false
 * Constraints: <= 1e4 nodes, values span the full int range
 *
 * Key idea:    Pass down an allowed (min, max) range; every node must lie strictly inside
 *              it. Use long bounds because node values can equal Integer.MIN/MAX. (Inorder
 *              must be strictly increasing is the alternative.)
 *
 * Approach:    DFS with (min, max) bounds as long
 * Complexity:  time O(n), space O(h)
 * Submitted:   2026-01-18 (submission 1889092893, AC)
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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max){
        // root.val should be in the range [min+1, max-1]
        if(root == null ) return true; 

        if(root.val >= max || root.val <= min) return false; 

        boolean isLeftSubTreeValid = isValidBST(root.left, min, root.val); 
        boolean isRightSubTreeValid = isValidBST(root.right, root.val, max); 

        return isLeftSubTreeValid && isRightSubTreeValid;
    }
}