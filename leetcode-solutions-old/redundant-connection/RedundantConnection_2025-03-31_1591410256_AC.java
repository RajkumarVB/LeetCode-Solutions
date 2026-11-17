class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; 
        DisjointSet ds = new DisjointSet(n); 
        for(int [] edge : edges){
            int u = edge[0]; 
            int v = edge[1]; 
            if(ds.findParent(u) != ds.findParent(v)){
                ds.unionBySize(u,v);
            }else{
                return edge; 
            }
        }
        return new int[]{-1,-1}; 
    }
}

class DisjointSet{
    private int[] size; 
    private int[] parent; 

    public DisjointSet(int V){
        size = new int[V+1]; 
        parent = new int[V+1]; 
        for(int i=0; i<=V; i++){
            size[i] = 1; 
            parent[i] = i; 
        }
    }

    public int findParent(int u){
        // return utimate parent; 

        if(parent[u] == u) return u; 
        return parent[u] = findParent(parent[u]); // path compression 
    }

    public void unionBySize(int u, int v){
        int uParent = findParent(u); 
        int vParent = findParent(v); 
        if(uParent == vParent) return ; 
        if(size[uParent] < size[vParent]){
            parent[uParent] = vParent; 
            size[vParent] += size[uParent]; 
        }else{
            parent[vParent] = uParent; 
            size[uParent] += size[vParent];   
        }

        // TC : 4 ALPHA
    }
}