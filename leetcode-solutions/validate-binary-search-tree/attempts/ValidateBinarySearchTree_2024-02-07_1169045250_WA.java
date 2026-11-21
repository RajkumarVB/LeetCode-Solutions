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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE); 
    }
    public boolean isValidBST(TreeNode root, int minRange, int maxRange){
        if(root == null) return true; 
        if(root.val <= minRange || root.val >= maxRange) return false; 
        return isValidBST(root.left,minRange,root.val) && isValidBST(root.right,root.val,maxRange); 
    }
}