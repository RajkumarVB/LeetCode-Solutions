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
    private int ans = Integer.MIN_VALUE; 
    public int maxPathSum(TreeNode root) {
        int rootPathSum = findMaxPathSum(root); 
        ans = Math.max(ans,rootPathSum); 
        return ans; 
    }
    public int findMaxPathSum(TreeNode root){
        if(root == null) return 0; 
        int leftMax = findMaxPathSum(root.left);
        int rightMax = findMaxPathSum(root.right);
        ans = Math.max(ans, leftMax + rightMax + root.val); 
        return root.val + Math.max(leftMax, rightMax); 
    }
}