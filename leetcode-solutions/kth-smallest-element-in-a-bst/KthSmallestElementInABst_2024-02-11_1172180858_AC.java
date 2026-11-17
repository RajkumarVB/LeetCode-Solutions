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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrderList = new ArrayList<>(); 
        Deque<TreeNode> stack = new LinkedList<>(); 
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.addLast(root); 
                root = root.left; 
            } else {
                TreeNode node = stack.removeLast(); 
                inOrderList.add(node.val); 
                root = node.right; 
            }
        }
        return inOrderList.get(k-1); 
    }
}