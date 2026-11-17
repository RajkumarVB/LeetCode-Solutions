/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = computeParent(root); 
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int distance = 0; 
        while(!q.isEmpty()){
            int size = q.size();
            if(distance == k) break;
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();

                if(node.left != null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                }

                if(node.right != null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                }
                if(parentMap.containsKey(node)){
                    TreeNode parent = parentMap.get(node);
                    if(!visited.contains(parent)){
                        q.offer(parent);
                        visited.add(parent);
                    }
                }
            }
            distance ++; 
        }

        List<Integer> result = new LinkedList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            result.add(node.val);
        }
        return result;


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