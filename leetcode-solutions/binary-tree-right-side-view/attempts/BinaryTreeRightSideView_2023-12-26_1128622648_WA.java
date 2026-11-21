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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new LinkedList<>();

        List<Integer> ans = new LinkedList<>(); 
        Deque<TreeNode> deque = new LinkedList<>(); 
        
        deque.addLast(root); 

        while(!deque.isEmpty()){
            TreeNode temp = deque.removeFirst();
            ans.add(temp.val); 
            if(temp.right != null) deque.addLast(temp.right); 
        }

        return ans; 
    }
}