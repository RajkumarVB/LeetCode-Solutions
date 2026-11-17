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
        LinkedList<TreeNode> queue = new LinkedList<>(); 

        queue.addLast(root); 

        while(!queue.isEmpty()){
            int n = queue.size(); 
            List<Integer> tempResult = new LinkedList<>(); 
            for(int i=0; i<n; i++){
                TreeNode node = queue.removeFirst(); 
                tempResult.add(node.val); 
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
            }
            result.add(tempResult); 
        }

        return result; 
    }
}