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