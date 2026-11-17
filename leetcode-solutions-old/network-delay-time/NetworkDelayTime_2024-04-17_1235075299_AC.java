class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adjList = new ArrayList<>(); 
        for(int i=0; i<=n; i++){
            adjList.add(new LinkedList<>()); 
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adjList.get(u).add(new Pair(v,w)); 
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[k] = 0; 
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.w - b.w); 
        pq.add(new Pair(k,0)); 

        while(!pq.isEmpty()){
            Pair p = pq.poll(); 
            int node = p.v; 
            int cost = p.w; 

            for(Pair neighbor : adjList.get(node)){
                int adjNode = neighbor.v; 
                int adjCost = neighbor.w; 
                if(cost + adjCost < dist[adjNode]){
                    dist[adjNode] = cost + adjCost;
                    pq.offer(new Pair(adjNode,cost+adjCost));
                }
            }
        }

        int minTotalTime =0; 

        // System.out.println(adjList);
        // System.out.println(Arrays.toString(dist));
        
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1; 
            minTotalTime = Math.max(minTotalTime, dist[i]); 
        }
        return minTotalTime; 

    }
    record Pair(int v, int w){

    }
}