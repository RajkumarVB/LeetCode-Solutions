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