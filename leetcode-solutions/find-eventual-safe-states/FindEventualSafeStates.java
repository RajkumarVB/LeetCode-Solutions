/*
 * 802. Find Eventual Safe States  [Medium]
 * https://leetcode.com/problems/find-eventual-safe-states/
 * Topics: Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort,
 *         Kosaraju's Algorithm, Tarjan's SCC Algorithm
 *
 * Problem:     In a directed graph, a node is safe if every path from it ends at a terminal
 *              node (no outgoing edges). Return all safe nodes, sorted.
 * Example:     graph=[[1,2],[2,3],[5],[0],[5],[],[]] -> [2,4,5,6]
 * Constraints: n <= 1e4, edges <= 4e4
 *
 * Key idea:    Reverse every edge; terminal nodes now have in-degree 0. Run Kahn's
 *              algorithm on the reversed graph: everything that gets removed can't reach a
 *              cycle, so it is safe.
 *
 * Approach:    Reverse graph + Kahn's topological sort
 * Complexity:  time O(V + E), space O(V + E)
 * Submitted:   2026-01-19 (submission 1889249163, AC)
 */

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjList = computeAdjList(graph, graph.length);

        int[] inDegree = computeInDegree(adjList, graph.length);
        List<Integer> topoSort = computeTopoSort(adjList, inDegree);

        topoSort.sort(null);
        return topoSort; 
    }

    private List<List<Integer>> computeAdjList(int[][] graph, int noOfNodes){
       List<List<Integer>> adjList = new ArrayList<>();
       for(int i=0; i<noOfNodes; i++){
            adjList.add(new LinkedList<>());
       }

       for(int i=0; i<graph.length; i++){
            for(int j=0; j< graph[i].length; j++){
                adjList.get(graph[i][j]).add(i);
            }
       }
       return adjList;
    }

    private int[] computeInDegree(List<List<Integer>> adjList, int noOfNodes){
        int[] inDegree = new int[noOfNodes];
        for(int i=0; i<adjList.size(); i++){
            for(int neighbor : adjList.get(i)){
                inDegree[neighbor]++;
            }
        }
        return inDegree;
    }

    private List<Integer> computeTopoSort(List<List<Integer>> adjList, int[] inDegree){
        LinkedList<Integer> q = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                q.addLast(i);
            }
        }
        List<Integer> result = new LinkedList<>();

        while(!q.isEmpty()){
            int node = q.removeFirst();
            result.add(node);

            for(int neighbor : adjList.get(node)){
                inDegree[neighbor]--; 
                if(inDegree[neighbor] == 0){
                    q.addLast(neighbor);
                }
            }
        }
        return result;
    }


}