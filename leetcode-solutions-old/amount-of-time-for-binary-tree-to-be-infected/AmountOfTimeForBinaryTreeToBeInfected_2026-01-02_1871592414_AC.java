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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parentMap = computeParent(root);
        TreeNode affectedNode = findNode(root, start);
        
        
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.offer(affectedNode);
        visited.add(affectedNode);
        int distance = 0; 
        while(!q.isEmpty()){
            int size = q.size();
            boolean infected = false; 

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();

                if(node.left != null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                    infected = true; 
                }

                if(node.right != null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                    infected = true;
                }
                if(parentMap.containsKey(node)){
                    TreeNode parent = parentMap.get(node);
                    if(!visited.contains(parent)){
                        q.offer(parent);
                        visited.add(parent);
                        infected = true;
                    }
                }
            }
            if(infected) distance ++; 
        }
        return distance; 
    }

    public TreeNode findNode(TreeNode root, int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(start == node.val) return node; 
            if(node.left != null){
                q.offer(node.left);
            }
            if(node.right != null){
                q.offer(node.right);
            }
        }
        return null;
    }

    private HashMap<TreeNode, TreeNode> computeParent(TreeNode root){
        // node -> parent
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.offer(node.left);
                parentMap.put(node.left, node); 
            }
            if(node.right != null){
                q.offer(node.right);
                parentMap.put(node.right, node); 
            }
        }
        return parentMap; 
    }
}