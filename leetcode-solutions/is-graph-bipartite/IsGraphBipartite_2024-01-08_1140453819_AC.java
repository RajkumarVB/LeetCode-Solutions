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