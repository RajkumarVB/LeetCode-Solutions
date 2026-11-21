/*
 * 1584. Min Cost to Connect All Points  [Medium]
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 * Topics: Array, Union-Find, Graph Theory, Minimum Spanning Tree, Prim's Algorithm,
 *         Kruskal's Algorithm, Borůvka's Algorithm
 *
 * Problem:     Connect all points with the minimum total Manhattan-distance edge cost.
 * Example:     [[0,0],[2,2],[3,10],[5,2],[7,0]] -> 20
 * Constraints: n <= 1000
 *
 * Key idea:    Minimum spanning tree. Prim's: start at any node, repeatedly take the
 *              cheapest edge to an unvisited node using a min-heap. Kruskal with union-find
 *              also works.
 *
 * Approach:    Prim's MST with min-heap (complete graph)
 * Complexity:  time O(n^2 log n), space O(n^2)
 * Submitted:   2024-04-18 (submission 1235931737, AC)
 */

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length; 
        List<List<Pair>> adjList = createAdjacenyList(points); 

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost); 
        boolean[] visited = new boolean[n]; 
        Arrays.fill(visited, false); 
        pq.offer(new Tuple(0,-1,0)); 
        int minCost = 0; 
        while(!pq.isEmpty()){
            Tuple t = pq.poll(); 
            int node = t.node; 
            int parent = t.parent; 
            int cost = t.cost; 

            if(visited[node]) continue;
            visited[node] = true; 
            minCost += cost; 
            for(Pair neighbor : adjList.get(node)){
                int adjNode = neighbor.node; 
                int adjCost = neighbor.cost; 
                if(visited[adjNode] == false){
                    pq.offer(new Tuple(adjNode, node, adjCost)); 
                }
            }
        }
        return minCost; 
    }

    public List<List<Pair>> createAdjacenyList(int[][] points){
        int n = points.length; 
        List<List<Pair>> adjList = new ArrayList<>(); 
        for(int i=0; i<n; i++){
            adjList.add(new LinkedList<>()); 
        }

        for(int i=0; i<n; i++){
            int u = i; 
            for(int j=i+1; j<n; j++){
                int v = j; 
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int cost = (int) (Math.abs(x1 - x2) + Math.abs(y1 - y2)); 
                adjList.get(u).add(new Pair(v,cost)); 
                adjList.get(v).add(new Pair(u,cost)); 
            }
        }
        return adjList; 
    }

    record Pair(int node, int cost){
 
    }

    record Tuple(int node, int parent, int cost){

    }
}