/*
 * 230. Kth Smallest Element in a BST  [Medium]
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Topics: Tree, Depth-First Search, Binary Search Tree, Binary Tree
 *
 * Problem:     Return the kth smallest value in a binary search tree.
 * Example:     [3,1,4,null,2], k=1 -> 1
 * Constraints: n <= 1e4
 *
 * Key idea:    Inorder traversal of a BST visits values in sorted order. Stop at the kth
 *              visit; an iterative stack makes stopping early easy.
 *
 * Approach:    Full inorder into a list
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: Iterative inorder with early stop
 * Submitted:   2024-02-11 (submission 1172168004, AC)
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
    List<Integer> inOrderList = new ArrayList<>(); 
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root); 
        return inOrderList.get(k-1); 
    }
    public void inOrder(TreeNode root){
        if(root == null) return; 
        inOrder(root.left);
        inOrderList.add(root.val);
        inOrder(root.right);
    }
}