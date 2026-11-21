/*
 * 235. Lowest Common Ancestor of a Binary Search Tree  [Medium]
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Topics: Tree, Depth-First Search, Binary Search Tree, Binary Tree, Binary Lifting, Lowest
 *         Common Ancestor
 *
 * Problem:     Find the lowest common ancestor of two nodes in a binary search tree.
 * Example:     root=[6,2,8,0,4,7,9,null,null,3,5], p=2, q=8 -> 6
 * Constraints: 2..1e5 nodes
 *
 * Key idea:    Use the BST order: if both values are smaller go left, if both are larger go
 *              right; otherwise the current node is where they split, so it's the LCA.
 *
 * Approach:    Follow BST order until p and q split
 * Complexity:  time O(h), space O(h)
 * Also see:    _2: General binary-tree LCA (ignores BST order)
 * Submitted:   2024-02-11 (submission 1172152116, AC)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q); 
        }
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q); 
        }
        return root; 
    }
}