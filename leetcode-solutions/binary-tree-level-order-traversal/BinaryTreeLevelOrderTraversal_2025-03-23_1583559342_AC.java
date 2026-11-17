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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>(); 
        List<List<Integer>> result = new LinkedList<>(); 
        Queue<TreeNode> q = new LinkedList<>(); 
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> tempAns = new LinkedList<>(); 
            for(int i=0; i<levelSize; i++){
                TreeNode node = q.poll(); 
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                tempAns.add(node.val); 
            }
            result.add(tempAns); 
        }
        return result; 
    }
}