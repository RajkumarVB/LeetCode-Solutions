/*
 * 236. Lowest Common Ancestor of a Binary Tree  [Medium]
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Topics: Tree, Depth-First Search, Binary Tree, Binary Lifting, Lowest Common Ancestor
 *
 * Problem:     Find the lowest common ancestor of two nodes in a general binary tree.
 * Example:     root=[3,5,1,6,2,0,8,null,null,7,4], p=5, q=1 -> 3
 * Constraints: 2..1e5 nodes
 *
 * Key idea:    Return the node if it's null, p or q. Recurse left and right: if both sides
 *              return non-null, this node is the LCA; otherwise pass up the non-null side.
 *
 * Approach:    Post-order DFS returning found node
 * Complexity:  time O(n), space O(h)
 * Submitted:   2024-01-05 (submission 1137289206, AC)
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
        if(root == null || root == p || root == q) return root; 
        
        TreeNode left = lowestCommonAncestor(root.left, p, q); 
        TreeNode right = lowestCommonAncestor(root.right, p, q); 

        if(left != null && right != null) return root; 
        return (left == null) ? right : left; 
    }
}