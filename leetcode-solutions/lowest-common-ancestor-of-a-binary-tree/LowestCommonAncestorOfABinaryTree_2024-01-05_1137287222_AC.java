/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; 
        if(root == p || root == q) return root; 
        
        TreeNode temp1 = lowestCommonAncestor(root.left, p, q); 
        TreeNode temp2 = lowestCommonAncestor(root.right, p, q); 
        
        if(temp1 == null && temp2 == null) return null; 
        if(temp1 != null && temp2 != null) return root; 
        if(temp1 == null) return temp2; 
        return temp1; 
    }
}