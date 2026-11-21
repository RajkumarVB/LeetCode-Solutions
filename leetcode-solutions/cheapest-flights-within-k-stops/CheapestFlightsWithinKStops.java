/*
 * 787. Cheapest Flights Within K Stops  [Medium]
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * Topics: Dynamic Programming, Depth-First Search, Breadth-First Search, Graph Theory, Heap
 *         (Priority Queue), Shortest Path
 *
 * Problem:     Given directed weighted flights, find the cheapest price from src to dst
 *              using at most k stops (k+1 edges). Return -1 if impossible.
 * Example:     n=4, flights=[[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src=0,
 *              dst=3, k=1 -> 700
 * Constraints: n <= 100
 *
 * Key idea:    Plain Dijkstra fails because a cheaper path may use too many stops. BFS
 *              level by level (stops as the level), relaxing costs; stop expanding after k
 *              stops. Bellman-Ford with k+1 rounds is the textbook alternative.
 *
 * Approach:    BFS by stops with cost relaxation
 * Complexity:  time O(k * E), space O(n + E)
 * Submitted:   2024-04-17 (submission 1235059259, AC)
 */

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new LinkedList<>()); 
        }

        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            adjList.get(u).add(new Pair(v,cost));
        }
        int[] dist = new int[n]; 
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0; 

        Queue<Route> q = new LinkedList<>(); 
        q.offer(new Route(src,0,0)); 
        while(!q.isEmpty()){
            Route r = q.poll(); 
            int node = r.node; 
            int cost = r.cost; 
            int stops = r.stops; 
            if(stops > k) continue; 

            for(Pair neighbor : adjList.get(node)){
                int adjNodeCost = neighbor.cost; 
                int adjNode = neighbor.node; 
                if(cost + adjNodeCost < dist[adjNode]){
                    dist[adjNode] = cost + adjNodeCost; 
                    q.offer(new Route(adjNode, cost + adjNodeCost, stops+1)); 
                }
            }
        }
        
        if(dist[dst] != Integer.MAX_VALUE) return dist[dst]; 
        return -1; 
    }


    record Pair(int node, int cost){

    }

    record Route(int node, int cost, int stops){

    }
}