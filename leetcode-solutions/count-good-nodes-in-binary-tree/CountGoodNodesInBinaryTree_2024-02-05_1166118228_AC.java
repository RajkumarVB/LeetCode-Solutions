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
    private int goodNodesCount = 0; 

    public int goodNodes(TreeNode root) {
        countGoodNodes(root, Integer.MIN_VALUE);
        return goodNodesCount;
    }

    public void countGoodNodes(TreeNode root, int prevMax){
        if(root == null) return; 
        if(root.val >= prevMax) goodNodesCount++; 
        int newMax = Math.max(prevMax,root.val); 
        countGoodNodes(root.left,newMax);
        countGoodNodes(root.right,newMax);
    }
}