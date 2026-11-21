/*
 * 133. Clone Graph  [Medium]
 * https://leetcode.com/problems/clone-graph/
 * Topics: Hash Table, Depth-First Search, Breadth-First Search, Graph Theory
 *
 * Problem:     Return a deep copy of a connected undirected graph given one of its nodes.
 * Example:     adjList=[[2,4],[1,3],[2,4],[1,3]] -> identical copy
 * Constraints: <= 100 nodes
 *
 * Key idea:    DFS with a map original -> clone. Put the clone in the map before recursing
 *              into neighbours; the map doubles as the visited set and handles cycles.
 *
 * Approach:    DFS with old->new HashMap
 * Complexity:  time O(V + E), space O(V)
 * Submitted:   2024-03-19 (submission 1207860626, AC)
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> oldToNew = new HashMap<>(); 
    
    public Node cloneGraph(Node node) {
        if(node == null) return null; 
        return clone(node);
    }

    public Node clone(Node node){
        if(oldToNew.containsKey(node)){
            return oldToNew.get(node);
        }
        Node copy = new Node(node.val); 
        oldToNew.put(node,copy); 
        for(Node neighbor : node.neighbors){
            Node copyNeighbor = clone(neighbor);
            copy.neighbors.add(copyNeighbor);
        }
        return copy; 
    }
}