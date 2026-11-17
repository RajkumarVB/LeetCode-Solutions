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
    private int[] preorder; 
    private int[] inorder; 
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder; 
        this.inorder = inorder; 
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i); 
        }
        TreeNode root = buildTree(0, inorder.length -1 , 0, preorder.length-1);
        return root; 
    }

    public TreeNode buildTree(int inStart, int inEnd, int preStart, int preEnd){
        if(inStart > inEnd || preStart > preEnd) return null; 
        int rootVal = preorder[preStart]; 
        TreeNode root = new TreeNode(rootVal); 
        int i = inorderMap.get(rootVal); 
        int noOfNodesInLeftSubTree = i -inStart; 
        int noOfNodesInRightSubTree = inEnd - i +1 ; 
        root.left = buildTree(inStart, inStart + noOfNodesInLeftSubTree -1, preStart + 1 , preStart + noOfNodesInLeftSubTree);
        root.right = buildTree(i+1, inEnd,preStart + noOfNodesInLeftSubTree+1,preEnd);
        return root; 
    }
}