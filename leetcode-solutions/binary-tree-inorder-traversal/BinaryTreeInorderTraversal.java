/*
 * 94. Binary Tree Inorder Traversal  [Easy]
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Topics: Stack, Tree, Depth-First Search, Binary Tree
 *
 * Problem:     Return the inorder (left, node, right) traversal of a binary tree.
 * Example:     [1,null,2,3] -> [1,3,2]
 * Constraints: 0..100 nodes
 *
 * Key idea:    Iterative version: push all left children onto a stack, pop one, visit it,
 *              then move to its right child.
 *
 * Approach:    Iterative with explicit stack
 * Complexity:  time O(n), space O(h)
 * Submitted:   2023-10-19 (submission 1078864385, AC)
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode temp = root; 
        while(temp != null || !stack.isEmpty()){
            while(temp != null){
                stack.offerLast(temp);
                temp = temp.left; 
            }
            temp = stack.pollLast();
            ans.add(temp.val);
            temp = temp.right; 
        }
        return ans;
    }
}