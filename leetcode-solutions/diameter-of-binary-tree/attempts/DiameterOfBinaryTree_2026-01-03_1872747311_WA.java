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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0; 

        return findHeight(root.left) + findHeight(root.right); 
    }

    private int findHeight(TreeNode root){
        if(root == null) return 0; 

        int leftSubTreeHeight = findHeight(root.left);
        int rightSubTreeHeight = findHeight(root.right);

        return 1 + Math.max(leftSubTreeHeight , rightSubTreeHeight); 
    }
}