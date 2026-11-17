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
    public int rob(TreeNode root) {
        Pair p = dfs(root);
        return Math.max(p.withRoot, p.withoutRoot);
        
    }
    private Pair dfs(TreeNode root){
        if(root == null){
            return new Pair(0,0); 
        }

        // with root

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);


        int withRoot = root.val + left.withoutRoot + right.withoutRoot; 
        int withoutRoot = Math.max(left.withRoot, left.withoutRoot) + Math.max(right.withRoot, right.withoutRoot); 

        return new Pair(withRoot, withoutRoot); 
    }

    record Pair(int withRoot, int withoutRoot){

    }
}