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
    private int goodNodes ; 
    public int goodNodes(TreeNode root) {
        goodNodes = 0; 

        computeGoodNodesCount(root, Integer.MIN_VALUE);
        return goodNodes; 
    }

    private void computeGoodNodesCount(TreeNode root, int maxValueInThePath){
        if(root == null) return; 

        if(root.val >= maxValueInThePath){
            goodNodes ++; 
            maxValueInThePath = root.val; 
        }

        computeGoodNodesCount(root.left, maxValueInThePath);
        computeGoodNodesCount(root.right, maxValueInThePath);
    }
}