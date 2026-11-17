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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int min, int max){
        // root.val should be in the range [min+1, max-1]
        if(root == null ) return true; 

        if(root.val >= max || root.val <= min) return false; 

        boolean isLeftSubTreeValid = isValidBST(root.left, min, root.val); 
        boolean isRightSubTreeValid = isValidBST(root.right, root.val, max); 

        return isLeftSubTreeValid && isRightSubTreeValid;
    }
}