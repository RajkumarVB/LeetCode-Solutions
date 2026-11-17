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
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        solveLevelOrder(root);
        return ans; 
    }
    public void solveLevelOrder(TreeNode root){
        if(root ==null) return; 
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while(!deque.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int size = deque.size();
            for(int i =0; i<size; i++){
                TreeNode temp = deque.pollFirst();
                level.add(temp.val);
                if(temp.left != null) deque.add(temp.left);
                if(temp.right != null) deque.add(temp.right);
            }
            ans.add(level);
        }
    }
}