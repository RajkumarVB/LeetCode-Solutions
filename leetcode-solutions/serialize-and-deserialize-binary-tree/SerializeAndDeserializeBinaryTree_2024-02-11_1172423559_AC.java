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
        StringBuilder result = new StringBuilder(); 
        Queue<TreeNode> q = new LinkedList<>(); 
        q.offer(root); 
        while(!q.isEmpty()){
            TreeNode node = q.poll(); 
            if(node!= null){
                result.append(node.val + ","); 
            } else{
                result.append("n,"); 
                continue; 
            }
            q.offer(node.left);
            q.offer(node.right);
        }
        System.out.println(result.toString());
        return result.toString(); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null; 
        String[] values = data.split(","); 
        // Arrays.stream(values).forEach(str -> System.out.print(str + " ")); 
        TreeNode root = new TreeNode(Integer.valueOf(values[0])); 
        Queue<TreeNode> q = new LinkedList<>(); 
        int itr = 1; 
        q.offer(root); 
        while(!q.isEmpty()){
            TreeNode node = q.poll(); 
            if(!values[itr].equals("n")){
                int leftVal = Integer.valueOf(values[itr]); 
                node.left = new TreeNode(leftVal);
                q.offer(node.left);
                itr ++; 
            } else{
                itr ++; 
            }
            if(!values[itr].equals("n")){
                int rightVal = Integer.valueOf(values[itr]); 
                node.right = new TreeNode(rightVal); 
                q.offer(node.right); 
                itr++; 
            } else{
                itr ++; 
            }
        }
        return root; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));