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
 * Approach:    Iterative inorder with early stop
 * Complexity:  time O(h + k), space O(h)
 * Also see:    _2: Full inorder into a list
 * Submitted:   2026-01-18 (submission 1889118709, AC)
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
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.add(root);
                root = root.left;
            }else{
                TreeNode node = stack.removeLast();
                k --; 
                if(k == 0) return node.val; 
                root = node.right; 
            }
        }

        return -1; 
    }
}