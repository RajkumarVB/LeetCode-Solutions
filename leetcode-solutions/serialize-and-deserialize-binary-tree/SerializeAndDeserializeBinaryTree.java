/*
 * 297. Serialize and Deserialize Binary Tree  [Hard]
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Topics: String, Tree, Depth-First Search, Breadth-First Search, Design, Binary Tree
 *
 * Problem:     Design serialize(tree) -> string and deserialize(string) -> tree for any
 *              binary tree.
 * Example:     [1,2,3,null,null,4,5] round-trips unchanged
 * Constraints: <= 1e4 nodes
 *
 * Key idea:    Level-order: write values with a null marker for missing children. To
 *              rebuild, read tokens in pairs (left, right) for each node polled from a
 *              queue. Pre-order DFS with null markers also works.
 *
 * Approach:    BFS with null markers
 * Complexity:  time O(n), space O(n)
 * Submitted:   2026-01-19 (submission 1889184973, AC)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.

    // "1,2,3,n,n,4,5,n,n,n,n,"
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        
        StringBuilder ans = new StringBuilder();

        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node != null){
                ans.append(node.val +",");
                q.offer(node.left);
                q.offer(node.right);
            }else{
                ans.append("n,");
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null; 
        
        String[] input = data.split(",");
        int n = input.length; 
        
        

        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i=1; 

        while(i < n && !q.isEmpty()) {
           TreeNode node = q.poll(); 
           String inputVal = input[i];

           if(!inputVal.equals("n")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(inputVal)); 
                node.left = leftNode; 
                q.offer(leftNode);
           }
           i++;


           if(i < n){
                inputVal = input[i];
                if(!inputVal.equals("n")){
                    TreeNode rightNode = new TreeNode(Integer.parseInt(inputVal)); 
                    node.right = rightNode; 
                    q.offer(rightNode);
                }
                i++; 
           }

        }
        return root; 
  
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));