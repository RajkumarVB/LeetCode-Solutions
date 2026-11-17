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
        if(root == null) return 0;
        diameter = 0; 
        computeHeight(root);
        return diameter; 
    }

    private int computeHeight(TreeNode root){
        if(root == null) return 0; 
        int leftSubTreeHeight = computeHeight(root.left);
        int rightSubTreeHeight = computeHeight(root.right);

        diameter = Math.max(diameter, leftSubTreeHeight + rightSubTreeHeight);
        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
    }
}