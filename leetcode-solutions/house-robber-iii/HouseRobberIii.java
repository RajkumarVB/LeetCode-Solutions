/*
 * 337. House Robber III  [Medium]
 * https://leetcode.com/problems/house-robber-iii/
 * Topics: Dynamic Programming, Tree, Depth-First Search, Binary Tree, DP on Trees
 *
 * Problem:     Houses form a binary tree; you can't rob a node and its direct parent on the
 *              same night. Return the maximum you can rob.
 * Example:     [3,2,3,null,3,null,1] -> 7
 * Constraints: <= 1e4 nodes
 *
 * Key idea:    DP on trees: each DFS returns a pair (best if this node is robbed, best if
 *              it is not). robbed = val + children's not-robbed; notRobbed = sum of
 *              max(child pair).
 *
 * Approach:    Post-order DFS returning (with, without) pair
 * Complexity:  time O(n), space O(h)
 * Submitted:   2026-01-06 (submission 1875913030, AC)
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
    public int rob(TreeNode root) {
        Pair p = dfs(root);
        return Math.max(p.withRoot, p.withoutRoot);
        
    }
    private Pair dfs(TreeNode root){
        if(root == null){
            return new Pair(0,0); 
        }

        // with root

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);


        int withRoot = root.val + left.withoutRoot + right.withoutRoot; 
        int withoutRoot = Math.max(left.withRoot, left.withoutRoot) + Math.max(right.withRoot, right.withoutRoot); 

        return new Pair(withRoot, withoutRoot); 
    }

    record Pair(int withRoot, int withoutRoot){

    }
}