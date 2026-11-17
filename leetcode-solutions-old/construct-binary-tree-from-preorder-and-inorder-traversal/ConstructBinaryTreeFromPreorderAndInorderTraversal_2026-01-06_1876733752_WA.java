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
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        int n = preorder.length; 
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i); 
        }

        return buildTree(preorder, inorder, 0,n-1,0,n-1, inorderMap);
    }


    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> inorderMap){
        if(inStart > inEnd || preStart > preEnd) return null; 
        TreeNode root = new TreeNode(preorder[preStart]); 
        int inOrderEnd = inorderMap.get(root.val) - 1; 

        int leftSubTreeNodes = inorderMap.get(root.val)  - inStart; 
        int rightSubTreeNodes = inEnd - inorderMap.get(root.val); 
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftSubTreeNodes, inStart, inOrderEnd, inorderMap); 
        root.right = buildTree(preorder, inorder, preStart + leftSubTreeNodes+1, preStart + rightSubTreeNodes+1, inorderMap.get(root.val) + 1
                        , inEnd, inorderMap); 
        return root; 
    }
}