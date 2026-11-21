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
 * Approach:    Recursive split, (start, length) ranges
 * Complexity:  time O(n), space O(n)
 * Also see:    _2: Recursive split, (start, end) ranges
 * Submitted:   2026-01-18 (submission 1889145973, AC)
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
        HashMap<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, n, 0, n, inOrderMap);
    }

    // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]


    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preLength, int inStart, int inLength, HashMap<Integer, Integer> inOrderMap){
        if(inLength == 0 || preLength ==0) return null; 
        int n = inLength; 


        TreeNode root = new TreeNode(preorder[preStart]);

        int leftSubTreeSize = inOrderMap.get(root.val) - inStart; 
        int rightSubTreeSize = n - leftSubTreeSize -1 ; 

        root.left = buildTree(preorder, inorder, preStart + 1, leftSubTreeSize, inStart,  leftSubTreeSize, inOrderMap);
        root.right = buildTree(preorder, inorder, preStart + 1 + leftSubTreeSize, rightSubTreeSize, inOrderMap.get(root.val) + 1,  rightSubTreeSize, inOrderMap);

        return root; 
    }

}