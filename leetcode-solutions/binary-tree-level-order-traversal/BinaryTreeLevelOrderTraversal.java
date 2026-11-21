/*
 * 102. Binary Tree Level Order Traversal  [Medium]
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Topics: Tree, Breadth-First Search, Binary Tree
 *
 * Problem:     Return the values of a binary tree level by level, left to right, as a list
 *              of lists.
 * Example:     [3,9,20,null,null,15,7] -> [[3],[9,20],[15,7]]
 * Constraints: 0..2000 nodes
 *
 * Key idea:    BFS with a queue; read q.size() at the start of each level so you know how
 *              many nodes belong to it.
 *
 * Approach:    BFS, process one level per iteration
 * Complexity:  time O(n), space O(n)
 * Submitted:   2026-01-18 (submission 1889050441, AC)
 */

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
        if(root == null) return new ArrayList<>();

        List<List<Integer>> result = new LinkedList<>(); 

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> tempResult = new LinkedList<>();
            for(int i=0; i<size; i++){
                TreeNode tempNode = q.poll(); 
                tempResult.add(tempNode.val);
                if(tempNode.left != null){
                    q.offer(tempNode.left);
                }
                if(tempNode.right != null){
                    q.offer(tempNode.right);
                }
            }
            result.add(tempResult);

        }
        return result;
    }
}