/*
 * 108. Convert Sorted Array to Binary Search Tree  [Easy]
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Topics: Array, Divide and Conquer, Tree, Binary Search Tree, Binary Tree
 *
 * Problem:     Turn a sorted array into a height-balanced binary search tree.
 * Example:     [-10,-3,0,5,9] -> [0,-3,9,-10,null,5]
 * Constraints: n <= 1e4
 *
 * Key idea:    Make the middle element the root and recurse on the left and right halves;
 *              this keeps the tree balanced.
 *
 * Approach:    Divide and conquer on the middle element
 * Complexity:  time O(n), space O(log n)
 * Submitted:   2023-12-27 (submission 1129111079, AC)
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(nums, 0, nums.length -1); 
    }
    public static TreeNode makeBST(int[] nums, int left, int right) {
        if(left > right) return null; 
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]); 
        root.left = makeBST(nums,left, mid-1);
        root.right = makeBST(nums,mid+1, right); 
        return root; 
    }
}