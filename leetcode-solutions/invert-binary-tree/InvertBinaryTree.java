/*
 * 226. Invert Binary Tree  [Easy]
 * https://leetcode.com/problems/invert-binary-tree/
 * Topics: Tree, Depth-First Search, Breadth-First Search, Binary Tree
 *
 * Problem:     Mirror a binary tree (swap every node's left and right children).
 * Example:     [4,2,7,1,3,6,9] -> [4,7,2,9,6,3,1]
 * Constraints: <= 100 nodes
 *
 * Key idea:    Swap children at each node and recurse. Pre-order or post-order both work.
 *
 * Approach:    Recursive swap (post-order)
 * Complexity:  time O(n), space O(h)
 * Submitted:   2026-01-18 (submission 1888817998, AC)
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
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root; 
    }

    private void invert(TreeNode root){
        if(root == null) return; 
        invert(root.left);
        invert(root.right);

        // swap left with Right

        TreeNode temp = root.left; 
        root.left = root.right;
        root.right = temp; 
    }
}