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
        maxSum = Integer.MIN_VALUE; 

        calculateMaxPathSum(root);
        return maxSum; 
    }

    private int calculateMaxPathSum(TreeNode root){
        if(root == null) return 0; 

        int leftSubTreeSum = calculateMaxPathSum(root.left); 
        int rightSubTreeSum = calculateMaxPathSum(root.right); 

        // whole tree
        // left subtree
        // right subtree
        // root alone
        
        int sumOfTree = leftSubTreeSum + rightSubTreeSum +root.val; 

        if(sumOfTree >= leftSubTreeSum && sumOfTree >= rightSubTreeSum && sumOfTree >= root.val){
            maxSum = Math.max(sumOfTree, maxSum);
            return sumOfTree; 
        }else if (leftSubTreeSum >= sumOfTree && leftSubTreeSum >= rightSubTreeSum && leftSubTreeSum >= root.val){
            maxSum = Math.max(leftSubTreeSum, maxSum);
            return leftSubTreeSum; 
        } else if (rightSubTreeSum >= sumOfTree && rightSubTreeSum >= leftSubTreeSum && rightSubTreeSum >= root.val){
            maxSum = Math.max(rightSubTreeSum, maxSum);
            return rightSubTreeSum; 
        }    
             
        maxSum = Math.max(root.val, maxSum);

        return leftSubTreeSum + rightSubTreeSum +root.val; 
    }

}