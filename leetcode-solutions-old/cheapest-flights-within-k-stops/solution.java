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