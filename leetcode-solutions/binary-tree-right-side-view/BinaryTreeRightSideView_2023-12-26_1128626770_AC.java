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
            int size = deque.size(); 
            
            for(int i=0; i<size; i++){
                TreeNode temp = deque.removeFirst(); 
                if(i == size-1) ans.add(temp.val); 
                if(temp.left != null) deque.add(temp.left);
                if(temp.right != null) deque.add(temp.right); 
            }
        }

        return ans; 
    }
}