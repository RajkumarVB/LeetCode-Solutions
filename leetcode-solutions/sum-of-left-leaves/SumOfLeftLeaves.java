/*
 * 404. Sum of Left Leaves  [Easy]
 * https://leetcode.com/problems/sum-of-left-leaves/
 * Topics: Tree, Depth-First Search, Breadth-First Search, Binary Tree
 *
 * Problem:     Return the sum of all leaves that are left children.
 * Example:     [3,9,20,null,null,15,7] -> 24
 * Constraints: <= 1000 nodes
 *
 * Key idea:    DFS passing an isLeft flag; add the value when the node is a leaf and isLeft
 *              is true.
 *
 * Approach:    DFS with isLeft flag
 * Complexity:  time O(n), space O(h)
 * Submitted:   2024-04-14 (submission 1232216805, AC)
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
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root,false); 
    }
    public int sum(TreeNode root, boolean isLeft){
        if(root == null) return 0; 
        if(isLeft && root.left ==null && root.right == null) return root.val; 
        return sum(root.left, true) + sum(root.right, false); 
    }
}