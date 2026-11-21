/*
 * 572. Subtree of Another Tree  [Easy]
 * https://leetcode.com/problems/subtree-of-another-tree/
 * Topics: Tree, Depth-First Search, String Matching, Binary Tree, Hash Function
 *
 * Problem:     Return whether subRoot appears as an exact subtree of root.
 * Example:     root=[3,4,5,1,2], subRoot=[4,1,2] -> true
 * Constraints: 2000 and 1000 nodes
 *
 * Key idea:    At every node of root, run isSameTree(node, subRoot). Faster methods:
 *              serialise both trees and do substring matching, or hash subtrees.
 *
 * Approach:    isSameTree at every node
 * Complexity:  time O(m * n), space O(h)
 * Submitted:   2024-02-05 (submission 1166100830, AC)
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false; 
        if(isSameTree(root,subRoot)) return true; 
        return isSubtree(root.left, subRoot) || isSubtree(root.right,subRoot); 
    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q ==null) return true; 
        if(p == null || q == null) return false; 
        if(p.val != q.val) return false ;
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right); 
    }
}