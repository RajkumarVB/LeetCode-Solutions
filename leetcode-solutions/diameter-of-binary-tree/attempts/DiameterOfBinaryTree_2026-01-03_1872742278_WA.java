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

        // leaf nodes are at height 0; 
        if(root.left == null && root.right == null) return 1; 

        int leftSubTreeHeight = diameterOfBinaryTree(root.left);
        int rightSubTreeHeight = diameterOfBinaryTree(root.right);

        return leftSubTreeHeight + rightSubTreeHeight; 
    }
}