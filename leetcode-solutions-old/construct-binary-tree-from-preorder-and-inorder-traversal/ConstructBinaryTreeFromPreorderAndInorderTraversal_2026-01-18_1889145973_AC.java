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