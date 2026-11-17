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
    private int maxSum; 
    public int maxPathSum(TreeNode root) {
        if(root != null && root.left == null && root.right == null) return root.val; 
        maxSum = Integer.MIN_VALUE; 

        calculateMaxPathSum(root);
        return maxSum; 
    }

    private int calculateMaxPathSum(TreeNode root){
        if(root == null) return 0; 

        int leftSubTreeSum = calculateMaxPathSum(root.left); 
        int rightSubTreeSum = calculateMaxPathSum(root.right); 

        maxSum = Math.max(leftSubTreeSum + rightSubTreeSum +root.val, maxSum);
        maxSum = Math.max(leftSubTreeSum, maxSum);
        maxSum = Math.max(rightSubTreeSum, maxSum);

        return leftSubTreeSum + rightSubTreeSum +root.val; 
    }

}