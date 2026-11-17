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
    private boolean isSubTree = false; 
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        checkSubTreeExists(root, subRoot);
        return isSubTree; 
    }

    private void checkSubTreeExists(TreeNode root, TreeNode subRoot){
        if(root == null || subRoot == null) return; 

        if(root.val == subRoot.val){
            boolean same = isSameTree(root, subRoot);
            if(same){
                isSubTree = true; 
            }
        }

        checkSubTreeExists(root.left, subRoot);
        checkSubTreeExists(root.right, subRoot);

    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true; 
        if(p == null && q != null) return false; 
        if(p != null && q == null) return false; 

        if(p.val != q.val) return false; 

        boolean isLeftSubTreeSame = isSameTree(p.left, q.left); 
        boolean isRightSubTreeSame = isSameTree(p.right, q.right); 
        return isLeftSubTreeSame && isRightSubTreeSame; 
    }
}