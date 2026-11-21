/*
 * 103. Binary Tree Zigzag Level Order Traversal  [Medium]
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Topics: Tree, Breadth-First Search, Binary Tree
 *
 * Problem:     Level-order traversal, but alternate direction each level: left-to-right,
 *              then right-to-left, and so on.
 * Example:     [3,9,20,null,null,15,7] -> [[3],[20,9],[15,7]]
 * Constraints: 0..2000 nodes
 *
 * Key idea:    Normal BFS; on odd levels insert each value at the front of the level list
 *              (or reverse the list) instead of changing the traversal order.
 *
 * Approach:    BFS + add-to-front on alternate levels
 * Complexity:  time O(n), space O(n)
 * Submitted:   2024-01-02 (submission 1134000706, AC)
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>(); 
        Deque<TreeNode> queue = new LinkedList<>(); 
        
        queue.addLast(root); 
        boolean isOddLevel = false; 
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempAns = new LinkedList<>(); 
            for(int i=0; i<size; i++){
                TreeNode temp = queue.removeFirst(); 
                if(isOddLevel) tempAns.add(0,temp.val); 
                else tempAns.add(temp.val); 
                if(temp.left != null) queue.addLast(temp.left);
                if(temp.right != null) queue.addLast(temp.right);
            }
            ans.add(tempAns); 
            isOddLevel = !isOddLevel; 
        }
        return ans; 
    }
}