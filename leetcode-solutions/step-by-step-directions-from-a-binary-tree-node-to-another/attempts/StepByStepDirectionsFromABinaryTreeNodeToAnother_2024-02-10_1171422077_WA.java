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