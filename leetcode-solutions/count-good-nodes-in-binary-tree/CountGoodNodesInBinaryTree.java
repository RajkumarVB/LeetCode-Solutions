/*
 * 1448. Count Good Nodes in Binary Tree  [Medium]
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * Topics: Tree, Depth-First Search, Breadth-First Search, Binary Tree
 *
 * Problem:     A node is 'good' if no node on the path from the root to it has a greater
 *              value. Count the good nodes.
 * Example:     [3,1,4,3,null,1,5] -> 4
 * Constraints: up to 1e5 nodes
 *
 * Key idea:    DFS passing down the maximum value seen on the path so far; a node is good
 *              if node.val >= that max.
 *
 * Approach:    DFS carrying path maximum
 * Complexity:  time O(n), space O(h)
 * Submitted:   2026-01-18 (submission 1889059708, AC)
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
    private int goodNodes ; 
    public int goodNodes(TreeNode root) {
        goodNodes = 0; 

        computeGoodNodesCount(root, Integer.MIN_VALUE);
        return goodNodes; 
    }

    private void computeGoodNodesCount(TreeNode root, int maxValueInThePath){
        if(root == null) return; 

        if(root.val >= maxValueInThePath){
            goodNodes ++; 
            maxValueInThePath = root.val; 
        }

        computeGoodNodesCount(root.left, maxValueInThePath);
        computeGoodNodesCount(root.right, maxValueInThePath);
    }
}