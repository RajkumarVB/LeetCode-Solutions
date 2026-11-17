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
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>() ;
        q.offer(root); 
        StringBuilder result = new StringBuilder(); 

        while(!q.isEmpty()){
            TreeNode node = q.poll(); 
            if(node == null){
                result.append("null,");
                continue; 
            }

            result.append(node.val + ",");
            q.offer(node.left);
            q.offer(node.right);
            
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null; 
        System.out.println("Data ==== " + data);

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0])); 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1; 
        int n = values.length; 
        while(i < n){
            TreeNode node = q.poll();
            if(!values[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(values[i]));
                q.offer(node.left);
            }
            i ++; 
            if(i < n && !values[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(values[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));