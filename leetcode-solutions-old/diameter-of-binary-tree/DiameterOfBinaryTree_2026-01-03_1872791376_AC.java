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
    private int diameter; 
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0; 
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        
        diameter = Math.max(leftHeight+ rightHeight , diameter);
        return diameter; 
    }

    private int findHeight(TreeNode root){
        if(root == null) return 0; 

        int leftSubTreeHeight = findHeight(root.left);
        int rightSubTreeHeight = findHeight(root.right);
        
        diameter = Math.max(leftSubTreeHeight + rightSubTreeHeight, diameter);

        return 1 + Math.max(leftSubTreeHeight , rightSubTreeHeight); 
    }
}