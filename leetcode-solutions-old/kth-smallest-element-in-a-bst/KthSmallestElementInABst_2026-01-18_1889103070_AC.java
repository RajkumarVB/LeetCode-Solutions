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
    private List<Integer> result; 
    public int kthSmallest(TreeNode root, int k) {
        result = new LinkedList<>();
        computeKthSmallest(root, k);
        return result.getLast(); 
    }

    private void computeKthSmallest(TreeNode root, int k){
        if(root == null) return; 

        computeKthSmallest(root.left, k);
        if(result.size() == k) return; 
        result.add(root.val);
        computeKthSmallest(root.right, k);
    }
}