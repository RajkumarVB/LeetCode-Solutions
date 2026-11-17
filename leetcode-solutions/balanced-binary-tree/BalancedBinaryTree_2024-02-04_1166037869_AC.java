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
    private boolean isBalanced = true; 

    public boolean isBalanced(TreeNode root) {
        return findHeight(root).isBalanced; 
    }

    public HeightAndIsBalanced findHeight(TreeNode root){
        if(root == null) return new HeightAndIsBalanced(0,true); 
        HeightAndIsBalanced leftSubTree = findHeight(root.left);
        HeightAndIsBalanced rightSubTree = findHeight(root.right);
        int height = 1 + Math.max(leftSubTree.height,rightSubTree.height); 
        boolean isBalanced = Math.abs(leftSubTree.height - rightSubTree.height) < 2  && leftSubTree.isBalanced && rightSubTree.isBalanced ; 
        return new HeightAndIsBalanced(height,isBalanced); 
    }

    record HeightAndIsBalanced(int height, boolean isBalanced){

    }
}