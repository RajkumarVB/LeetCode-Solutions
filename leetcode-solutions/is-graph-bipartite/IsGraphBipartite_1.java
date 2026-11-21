/*
 * 785. Is Graph Bipartite?  [Medium]
 * https://leetcode.com/problems/is-graph-bipartite/
 * Topics: Depth-First Search, Breadth-First Search, Union-Find, Graph Theory, Graph
 *         Coloring, Bipartite Graph
 *
 * Problem:     Can an undirected graph's nodes be split into two sets so that every edge
 *              connects the two sets?
 * Example:     [[1,3],[0,2],[1,3],[0,2]] -> true
 * Constraints: n <= 100, possibly disconnected
 *
 * Key idea:    Two-colour the graph with BFS or DFS: give neighbours the opposite colour. A
 *              neighbour that already has the same colour means an odd cycle, so it's not
 *              bipartite. Start from every uncoloured node.
 *
 * Approach:    BFS 2-colouring
 * Complexity:  time O(V + E), space O(V)
 * Also see:    _2: DFS 2-colouring
 * Submitted:   2024-01-08 (submission 1140453819, AC)
 */

class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length; 

        int[] color = new int[V]; // Since it's a zero based indexed graph. 
        Arrays.fill(color,-1); 
        // -1 means not colored. 
        // 0 means yellow colored
        // 1 means red colored

        for(int i=0; i<V; i++){
            if(color[i] == -1){
                if(!isBipartite(graph,color,V,i)) return false;
            }
        }
        return true; 
    }
    public boolean isBipartite(int[][] graph,int[] color, int V, int start){
        Deque<Integer> queue = new LinkedList<>(); 
        color[start] = 0; 
        queue.addLast(start); 

        while(!queue.isEmpty()){
            int node = queue.removeFirst(); 
            int nodeColor = color[node]; 
            for(int neighbor : graph[node]){
                if(color[neighbor] == -1){
                    color[neighbor] = 1 - nodeColor; 
                    queue.addLast(neighbor);
                } else if(color[neighbor] == nodeColor) return false; 
            }
        }
        return true; 
    }
}