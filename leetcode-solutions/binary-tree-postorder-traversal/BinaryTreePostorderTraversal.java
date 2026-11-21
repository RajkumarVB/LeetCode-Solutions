/*
 * 145. Binary Tree Postorder Traversal  [Easy]
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * Topics: Stack, Tree, Depth-First Search, Binary Tree
 *
 * Problem:     Return the postorder (left, right, node) traversal of a binary tree.
 * Example:     [1,null,2,3] -> [3,2,1]
 * Constraints: 0..100 nodes
 *
 * Key idea:    Recursive DFS: visit children first, then the node. Iterative trick: do a
 *              modified preorder (node, right, left) and reverse it.
 *
 * Approach:    Recursive DFS
 * Complexity:  time O(n), space O(h)
 * Submitted:   2023-10-18 (submission 1078053489, AC)
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
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return ans; 
    }
    public void traverse(TreeNode root){
        if(root ==null) return; 
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        ans.add(root.val);
    }
}