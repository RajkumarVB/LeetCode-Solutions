/*
 * 106. Construct Binary Tree from Inorder and Postorder Traversal  [Medium]
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * Topics: Array, Hash Table, Divide and Conquer, Tree, Binary Tree
 *
 * Problem:     Rebuild a binary tree (unique values) from its inorder and postorder
 *              traversals.
 * Example:     inorder=[9,3,15,20,7], postorder=[9,15,7,20,3] -> [3,9,20,null,null,15,7]
 * Constraints: n <= 3000
 *
 * Key idea:    The last postorder element is the root. Its index in inorder (via a HashMap)
 *              splits the left and right subtrees; the left subtree size tells you how to
 *              split postorder.
 *
 * Approach:    Recursive split with inorder index map
 * Complexity:  time O(n), space O(n)
 * Submitted:   2024-01-03 (submission 1135452366, AC)
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
    private HashMap<Integer,Integer> inorderMap = new HashMap<>(); 
    private int[] inorder;
    private int[] postorder; 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder; 
        this.postorder = postorder; 

        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i],i); 
        }

        TreeNode root = buildTree(0,inorder.length -1,0,postorder.length-1);
        return root; 
    }

    public TreeNode buildTree(int inStart, int inEnd, int posStart, int posEnd){
        if(inStart > inEnd || posStart > posEnd) return null; 
        int rootVal = postorder[posEnd]; 
        TreeNode root = new TreeNode(rootVal); 
        int i = inorderMap.get(rootVal); 
        int noOfLeftSubTreeNodes = i - inStart; 

        root.left = buildTree(inStart, inStart + noOfLeftSubTreeNodes -1, posStart, posStart + noOfLeftSubTreeNodes -1); 
        root.right = buildTree(i+1, inEnd, posStart + noOfLeftSubTreeNodes, posEnd-1); 
        return root; 
    }
}