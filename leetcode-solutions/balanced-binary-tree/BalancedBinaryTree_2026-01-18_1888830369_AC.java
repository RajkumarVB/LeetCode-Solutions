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
    private boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true; 
        isBalanced = true; 

        computeHeight(root);
        return isBalanced; 
    }

    private int computeHeight(TreeNode root){
        if(root == null) return 0; 
        int leftSubTreeHeight = computeHeight(root.left);
        int rightSubTreeHeight = computeHeight(root.right);

        if(Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
            isBalanced = false; 
        }

        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);

    }


}