/*
 * 199. Binary Tree Right Side View  [Medium]
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Topics: Tree, Depth-First Search, Breadth-First Search, Binary Tree
 *
 * Problem:     Looking at a binary tree from the right side, return the values you can see
 *              from top to bottom (the last node of each level).
 * Example:     [1,2,3,null,5,null,4] -> [1,3,4]
 * Constraints: 0..100 nodes
 *
 * Key idea:    Level-order BFS and record the last node of each level. (DFS visiting right
 *              first and recording the first node at each new depth also works.)
 *
 * Approach:    BFS, take last node per level
 * Complexity:  time O(n), space O(n)
 * Submitted:   2026-01-18 (submission 1889052055, AC)
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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> result = new LinkedList<>(); 

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                TreeNode tempNode = q.poll(); 
                if(i == size-1){
                    result.add(tempNode.val);
                }
                if(tempNode.left != null){
                    q.offer(tempNode.left);
                }
                if(tempNode.right != null){
                    q.offer(tempNode.right);
                }
            }

        }
        return result;
    }
}