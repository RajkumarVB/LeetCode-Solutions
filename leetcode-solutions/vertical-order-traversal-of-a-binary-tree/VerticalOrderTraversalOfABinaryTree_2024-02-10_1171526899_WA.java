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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return new LinkedList<>(); 
        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>(); 
        Queue<Point> q = new LinkedList<>(); 
        q.offer(new Point(root, 0, 0)); 
        while(!q.isEmpty()){
            Point point = q.poll(); 
            TreeNode node = point.node; 
            int x = point.x; 
            int y = point.y; 
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>()); 
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>()); 
            }
            map.get(x).get(y).add(node.val);
            if(node.left != null){
                q.offer(new Point(node.left, x-1,y+1));
            }
            if(node.right != null){
                q.offer(new Point(node.right, x+1,y+1));
            }
        }
        // System.out.println(map);
        List<List<Integer>> result = new ArrayList<>(); 
        for(var innerMap : map.values()){
            result.add(new LinkedList<>()); 
            for(var pq : innerMap.values()){
                for(var num : pq){
                    result.get(result.size() -1).add(num); 
                }
            }
        }
        return result; 
    }
    record Point(TreeNode node, int x, int y){

    }
}