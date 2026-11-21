/*
 * 144. Binary Tree Preorder Traversal  [Easy]
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Topics: Stack, Tree, Depth-First Search, Binary Tree
 *
 * Problem:     Return the preorder (node, left, right) traversal of a binary tree.
 * Example:     [1,null,2,3] -> [1,2,3]
 * Constraints: 0..100 nodes
 *
 * Key idea:    Iteratively: pop from a stack, visit, push right child then left child (so
 *              left is processed first).
 *
 * Approach:    Recursive DFS
 * Complexity:  time O(n), space O(h)
 * Also see:    _1: Iterative with stack (push right, then left)
 * Submitted:   2023-10-18 (submission 1078029326, AC)
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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        solvePreOrder(root);
        return ans; 
    }
    public void solvePreOrder(TreeNode root){
        if(root == null) return; 
        ans.add(root.val);
        solvePreOrder(root.left);
        solvePreOrder(root.right);
    }
}