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
 * Approach:    Iterative with stack (push right, then left)
 * Complexity:  time O(n), space O(h)
 * Also see:    _2: Recursive DFS
 * Submitted:   2023-10-19 (submission 1078843062, AC)
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root ==null) return ans; 
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pollLast();
            ans.add(temp.val);
            if(temp.right != null) stack.offerLast(temp.right);
            if(temp.left != null) stack.offerLast(temp.left);
        }
        return ans; 
    }
}