class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int nodes = edges.length; 
        DisjointSet ds = new DisjointSet(nodes); 
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(ds.findParent(u) == ds.findParent(v)){
                return edge; 
            } else {
                ds.union(u,v); 
            }
        }
        return new int[]{-1,-1}; // This will never be executed. 
    }
}

class DisjointSet{
    private int[] size; 
    private int[] parent; 
    public DisjointSet(int n){
        this.size = new int[n+1];
        this.parent = new int[n+1];
        for(int i=0; i<=n;i++){
            size[i] = 1; 
            parent[i] = i; 
        }
    }
    public int findParent(int node){
        // find ultimate parent
        if(node == parent[node]) return node; 
        return parent[node] = findParent(parent[node]); 
    }
    public void union(int u, int v){
        int uParentU = findParent(u);
        int uParentV = findParent(v);
        if(uParentU == uParentV) return; 
        if(size[uParentU] < size[uParentV]){
            parent[uParentU] = uParentV;
            size[uParentV] += size[uParentU];
        } else{
            parent[uParentV] = uParentU;
            size[uParentU] += size[uParentV]; 
        }
    }
}