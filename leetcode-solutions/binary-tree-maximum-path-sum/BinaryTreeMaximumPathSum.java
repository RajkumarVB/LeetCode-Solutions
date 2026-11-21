/*
 * 124. Binary Tree Maximum Path Sum  [Hard]
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * Topics: Dynamic Programming, Tree, Depth-First Search, Binary Tree, DP on Trees
 *
 * Problem:     A path is any sequence of connected nodes (each used at most once, not
 *              necessarily through the root). Return the largest possible path sum.
 * Example:     [-10,9,20,null,null,15,7] -> 42 (15 + 20 + 7)
 * Constraints: 1..3e4 nodes, values in [-1000, 1000]
 *
 * Key idea:    DFS returns the best downward path starting at a node (node + max(0, left,
 *              right)); at each node update the global answer with node + max(0,left) +
 *              max(0,right), the path that bends there.
 *
 * Approach:    Post-order DFS with global max, clamp negatives to 0
 * Complexity:  time O(n), space O(h)
 * Submitted:   2026-01-19 (submission 1890052014, AC)
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
    private int maxPathAns; 
    public int maxPathSum(TreeNode root) {
        maxPathAns = Integer.MIN_VALUE; 
        computeMaxPathSum(root);
        return maxPathAns; 
    }

    private int computeMaxPathSum(TreeNode root){
        if(root == null) return 0; 
        int leftSubTreeSum = computeMaxPathSum(root.left);
        int rightSubTreeSum = computeMaxPathSum(root.right);

        leftSubTreeSum = Math.max(0, leftSubTreeSum);
        rightSubTreeSum = Math.max(0, rightSubTreeSum);

        maxPathAns = Math.max(maxPathAns, leftSubTreeSum + rightSubTreeSum + root.val); 

        return root.val + Math.max(leftSubTreeSum, rightSubTreeSum);
    }
}