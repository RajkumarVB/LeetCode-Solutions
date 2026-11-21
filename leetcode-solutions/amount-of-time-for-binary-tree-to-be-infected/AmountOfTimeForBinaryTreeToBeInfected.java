/*
 * 2385. Amount of Time for Binary Tree to Be Infected  [Medium]
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 * Topics: Hash Table, Tree, Depth-First Search, Breadth-First Search, Binary Tree
 *
 * Problem:     An infection starts at the node with value start and spreads to adjacent
 *              nodes (children and parent) each minute. Return the minutes until the whole
 *              tree is infected.
 * Example:     root=[1,5,3,null,4,10,6,9,2], start=3 -> 4
 * Constraints: up to 1e5 nodes, unique values
 *
 * Key idea:    Same trick as 'distance K': build parent pointers, BFS from start; the
 *              answer is the number of BFS levels minus one.
 *
 * Approach:    Parent map + level BFS (count levels)
 * Complexity:  time O(n), space O(n)
 * Submitted:   2026-01-23 (submission 1894082129, AC)
 */

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
        TreeNode infectedNode = findNode(start, root);

        LinkedList<TreeNode> q = new LinkedList<>();
        
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(infectedNode);

        q.offer(infectedNode); 

        int time = -1; 
        while(!q.isEmpty()){
            int size = q.size();
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

                TreeNode parent = parentMap.get(node);
                if(parent != null && !visited.contains(parent)){
                    q.offer(parent);
                    visited.add(parent);
                }
            }

            time ++ ; 
        }
        return time; 
    }

    private HashMap<TreeNode, TreeNode> computeParent(TreeNode root){
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        if(root == null) return parentMap; 

        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                parentMap.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null){
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }

        return parentMap; 
    }


    private TreeNode findNode(int val, TreeNode root){
        if(root == null) return null; 
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.val == val) return node; 
            
            if(node.left != null){
                q.offer(node.left);
            }

            if(node.right != null){
                q.offer(node.right);
            }
        }
        return null; 
    }
}