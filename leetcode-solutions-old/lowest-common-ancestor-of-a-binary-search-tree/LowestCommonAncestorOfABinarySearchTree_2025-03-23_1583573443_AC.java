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
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q); 
        }

        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q); 
        }

        TreeNode leftSearch = lowestCommonAncestor(root.left, p, q); 
        TreeNode rightSearch = lowestCommonAncestor(root.right, p, q); 
        if(leftSearch != null && rightSearch != null) return root; 
        if(leftSearch != null) return leftSearch;
        return rightSearch;

    }
}