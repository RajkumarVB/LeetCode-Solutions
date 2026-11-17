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