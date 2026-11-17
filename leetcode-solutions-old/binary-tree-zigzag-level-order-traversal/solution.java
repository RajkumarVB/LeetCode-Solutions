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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>(); 
        Deque<TreeNode> queue = new LinkedList<>(); 
        
        queue.addLast(root); 
        boolean isOddLevel = false; 
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempAns = new LinkedList<>(); 
            for(int i=0; i<size; i++){
                TreeNode temp = queue.removeFirst(); 
                if(isOddLevel) tempAns.add(0,temp.val); 
                else tempAns.add(temp.val); 
                if(temp.left != null) queue.addLast(temp.left);
                if(temp.right != null) queue.addLast(temp.right);
            }
            ans.add(tempAns); 
            isOddLevel = !isOddLevel; 
        }
        return ans; 
    }
}