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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode temp = root; 
        while(temp != null || !stack.isEmpty()){
            while(temp != null){
                stack.offerLast(temp);
                temp = temp.left; 
            }
            temp = stack.pollLast();
            ans.add(temp.val);
            temp = temp.right; 
        }
        return ans;
    }
}