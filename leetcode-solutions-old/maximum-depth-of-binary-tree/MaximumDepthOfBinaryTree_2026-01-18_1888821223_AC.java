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
    private int maxDepth; 
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; 
        maxDepth = 1; 

        computeDepth(root, 1);
        return maxDepth; 
    }

    private void computeDepth(TreeNode root, int depth){
        if(root == null) return; 

        maxDepth = Math.max(maxDepth, depth);
        computeDepth(root.left, depth + 1); 
        computeDepth(root.right, depth + 1); 
    }
}