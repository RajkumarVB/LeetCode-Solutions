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
    Deque<TreeNode> deque = new LinkedList<>(); 

    public List<List<Integer>> levelOrder(TreeNode node) {
        List<List<Integer>> ans = new LinkedList<>(); 
        if(node == null) return new LinkedList<>(); 
        deque.addLast(node); 

        while(deque.size() != 0){
            List<Integer> tempAns = new LinkedList<>(); 
            int size = deque.size(); 
            while(size-- != 0){
                TreeNode temp = deque.getFirst(); 
                tempAns.add(temp.val); 
                if(temp.left != null) deque.addLast(temp.left);
                if(temp.right != null) deque.addLast(temp.right);
                deque.removeFirst();
            }
            ans.add(tempAns); 
        } 
        return ans; 
    }
}