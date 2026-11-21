/*
 * 104. Maximum Depth of Binary Tree  [Easy]
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Topics: Tree, Depth-First Search, Breadth-First Search, Binary Tree
 *
 * Problem:     Return the number of nodes on the longest root-to-leaf path.
 * Example:     [3,9,20,null,null,15,7] -> 3
 * Constraints: <= 1e4 nodes
 *
 * Key idea:    depth(node) = 1 + max(depth(left), depth(right)). BFS counting levels also
 *              works.
 *
 * Approach:    Top-down DFS passing depth
 * Complexity:  time O(n), space O(h)
 * Also see:    _1: Recursive DFS (bottom-up); _2: BFS counting levels
 * Submitted:   2026-01-18 (submission 1888821223, AC)
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
    private int maxDepth; 
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; 
        maxDepth = 1; 

        computeDepth(root, 1);
        return maxDepth; 
    }

    private void computeDepth(TreeNode root, int depth){
        if(root == null) return; 

        maxDepth = Math.max(maxDepth, depth);
        computeDepth(root.left, depth + 1); 
        computeDepth(root.right, depth + 1); 
    }
}