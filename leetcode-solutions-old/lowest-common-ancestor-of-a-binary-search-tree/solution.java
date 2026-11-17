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

        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p , q);
        }

        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p , q);
        }

        
        TreeNode searchResultLeft = lowestCommonAncestor(root.left, p ,q);
        TreeNode searchResultRight = lowestCommonAncestor(root.right, p ,q);

        if(searchResultLeft != null && searchResultRight != null) return root; 
        if(searchResultLeft != null) return searchResultLeft; 
        if(searchResultRight != null) return searchResultRight; 
        return null; 
    }
}