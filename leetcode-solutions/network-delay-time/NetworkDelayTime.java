/*
 * 743. Network Delay Time  [Medium]
 * https://leetcode.com/problems/network-delay-time/
 * Topics: Depth-First Search, Breadth-First Search, Graph Theory, Heap (Priority Queue),
 *         Shortest Path, Dijkstra's Algorithm
 *
 * Problem:     A signal starts at node k in a weighted directed graph. Return the time
 *              until all nodes receive it, or -1.
 * Example:     times=[[2,1,1],[2,3,1],[3,4,1]], n=4, k=2 -> 2
 * Constraints: n <= 100, edges <= 6000, weights >= 0
 *
 * Key idea:    Single-source shortest paths with non-negative weights: Dijkstra with a min-
 *              heap. The answer is the maximum shortest distance, or -1 if some node is
 *              unreachable.
 *
 * Approach:    Dijkstra with min-heap
 * Complexity:  time O(E log V), space O(V + E)
 * Submitted:   2026-01-23 (submission 1894004251, AC)
 */

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> adjList = new ArrayList<>();
        for(int i=0; i<=n ;i++){
            adjList.add(new LinkedList<>());
        }

        for(int[] time : times){
            int u = time[0]; 
            int v = time[1];
            int w = time[2];
            
            adjList.get(u).add(new Node(v,w));
        }

        int[] minTime = findMinTime(adjList, k);


        int result = 0; 
        for(int i=1; i<=n ;i++){
            if(minTime[i] == Integer.MAX_VALUE) return -1; 
            result = Math.max(result, minTime[i]);
        }
        return result; 
    }

    private int[] findMinTime(List<List<Node>> adjList, int source){
        int n = adjList.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0; 
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.time - n2.time);
        pq.offer(new Node(source, 0));

        while(!pq.isEmpty()){

            int src = pq.peek().node;
            int time = pq.peek().time;
            pq.poll();

            for(Node node : adjList.get(src)){
                int newTime = time + node.time; 
                if(newTime < dist[node.node]){
                    dist[node.node] = newTime; 
                    pq.offer(new Node(node.node, newTime));
                }
            }
        }

        return dist; 
    }

    record Node(int node, int time){};
}