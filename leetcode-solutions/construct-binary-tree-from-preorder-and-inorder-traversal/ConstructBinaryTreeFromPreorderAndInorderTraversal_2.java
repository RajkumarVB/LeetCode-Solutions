/*
 * 105. Construct Binary Tree from Preorder and Inorder Traversal  [Medium]
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Topics: Array, Hash Table, Divide and Conquer, Tree, Binary Tree
 *
 * Problem:     Rebuild a binary tree (unique values) from its preorder and inorder
 *              traversals.
 * Example:     preorder=[3,9,20,15,7], inorder=[9,3,15,20,7] -> [3,9,20,null,null,15,7]
 * Constraints: n <= 3000
 *
 * Key idea:    preorder[preStart] is the root; find it in inorder with a HashMap. leftSize
 *              = rootIdx - inStart. Left subtree is preorder[preStart+1 ..
 *              preStart+leftSize], right is the rest.
 *
 * Approach:    Recursive split, (start, end) ranges
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: Recursive split, (start, length) ranges
 * Submitted:   2024-02-11 (submission 1172203278, AC)
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length; 
        HashMap<Integer,Integer> inMap = new HashMap<>(); 
        for(int i=0; i<n; i++){
            inMap.put(inorder[i],i); 
        }
        return buildTree(preorder,0,n-1,inorder,0,n-1, inMap); 
    }
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> inMap){
        if(inStart > inEnd || preStart > preEnd) return null; 
        TreeNode root = new TreeNode(preorder[preStart]); 
        int inRoot = inMap.get(root.val); 
        int leftSubTreeNodes = inRoot - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + leftSubTreeNodes, inorder, inStart, inRoot-1,inMap);
        root.right = buildTree(preorder, preStart +leftSubTreeNodes+ 1, preEnd, inorder, inRoot + 1 , inEnd, inMap);
        return root; 
    }
}