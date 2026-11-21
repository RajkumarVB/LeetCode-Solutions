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
 * Approach:    DFS 2-colouring
 * Complexity:  time O(V + E), space O(V)
 * Also see:    _1: BFS 2-colouring
 * Submitted:   2024-01-10 (submission 1142607134, AC)
 */

class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length; 
        int[] colors = new int[V];
        Arrays.fill(colors,-1); 
        for(int i=0; i<V; i++){
            if(colors[i] == -1){
                if(!isBipartite(graph,colors,i,0)) return false;
            }
        }
        return true; 
    }

    public boolean isBipartite(int[][]graph, int[] colors, int node, int color){
        colors[node] = color; 
        for(int neighbor : graph[node]){
            if(colors[neighbor] == -1){
                if(!isBipartite(graph,colors,neighbor, 1 -color)) return false; 
            } else if(colors[neighbor] == color) return false; 
        }
        return true; 
    }
}