/*
 * 2096. Step-By-Step Directions From a Binary Tree Node to Another  [Medium]
 * https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 * Topics: String, Tree, Depth-First Search, Binary Tree, Binary Lifting, Lowest Common
 *         Ancestor
 *
 * Problem:     Give the shortest path from node startValue to node destValue as a string of
 *              'L' (left child), 'R' (right child) and 'U' (parent).
 * Example:     root=[5,1,2,3,null,6,4], start=3, dest=6 -> "UURL"
 * Constraints: 2..1e5 nodes
 *
 * Key idea:    Find root->start and root->dest paths as L/R strings (DFS with
 *              backtracking). Strip their common prefix (that's the LCA). Answer = 'U' *
 *              remaining start path length + remaining dest path.
 *
 * STATUS:      NOT ACCEPTED - this is your latest attempt. Earlier attempts are in
 *              attempts/.
 * Submitted:   2024-02-10 (submission 1171422077, WA)
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
    private StringBuilder result; 
    private int resultDepth; 

    public Solution(){
        this.result = new StringBuilder(); 
        this.resultDepth = 0; 
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue); 
        // System.out.println("LCA VAL" + lca.val);
        findDepth(lca,startValue,0);
        // System.out.println("Result Depth = " + resultDepth);
        for(int i=0; i<resultDepth; i++){
            result.append('U'); 
        }
        searchDestValue(lca,destValue);
        return result.toString(); 
    }
    public TreeNode findLCA(TreeNode root, int val1, int val2){
        if(root == null) return root; 
        if(root.val == val1) return root; 
        if(root.val == val2) return root; 
        TreeNode leftSearch = findLCA(root.left, val1, val2); 
        TreeNode rightSearch = findLCA(root.right, val1, val2); 
        if(leftSearch != null && rightSearch != null) return root; 
        if(leftSearch == null && rightSearch == null) return root; 
        if(leftSearch != null) return leftSearch; 
        return rightSearch; 
    }
    public void findDepth(TreeNode root, int target, int depth){
        if(root == null) return; 
        if(root.val == target) {
            resultDepth = depth; 
            return; 
        }
        findDepth(root.left, target,depth+1);
        findDepth(root.right, target,depth+1);
    }
    public boolean searchDestValue(TreeNode root, int target){
        if(root == null){
            return false; 
        }
        if(root.val == target) return true; 
        result.append('L'); 
        boolean isFound = searchDestValue(root.left,target);
        if(isFound) return true; 
        result.deleteCharAt(result.length() -1); 
        result.append('R'); 
        isFound = searchDestValue(root.right,target);
        if(isFound) return true; 
        result.deleteCharAt(result.length() -1); 
        return false; 
    }
}