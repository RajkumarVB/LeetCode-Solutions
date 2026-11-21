/*
 * 104. Maximum Depth of Binary Tree  [Easy]
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Topics: Tree, Depth-First Search, Breadth-First Search, Binary Tree
 *
 * Problem:     Return the number of nodes on the longest root-to-leaf path.
 * Example:     [3,9,20,null,null,15,7] -> 3
 * Constraints: <= 1e4 nodes
 *
 * Key idea:    depth(node) = 1 + max(depth(left), depth(right)). BFS counting levels also
 *              works.
 *
 * Approach:    BFS counting levels
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: Recursive DFS (bottom-up); _3: Top-down DFS passing depth
 * Submitted:   2026-01-03 (submission 1872762873, AC)
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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; 

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0; 
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();

                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }
            }
            depth ++ ; 
        }
        return depth; 
    }
}