class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; 

        DisjointSet ds = new DisjointSet(n); 
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(ds.findUParent(u) == ds.findUParent(v)){
                return edge; 
            }else{
                ds.unionBySize(u, v);
            }
        }
        return new int[]{-1,-1};
    }
}

class DisjointSet{
    int[] size; 
    int[] parent; 

    public DisjointSet(int noOfNodes){
        size = new int[noOfNodes+1];
        parent = new int[noOfNodes+1];

        for(int i=0; i<= noOfNodes; i++){
            size[i] = 1; 
            parent[i] = i; 
        }
    }

    public int findUParent(int node){
        if(parent[node] == node) return node; 
        return parent[node] = findUParent(parent[node]); 
    }

    public void unionBySize(int u, int v){
        int uParentU = findUParent(u);
        int uParentV = findUParent(v);

        if(uParentU == uParentV) return; 
        if(size[uParentU] < size[uParentV]){
            // u is a smaller component than v
            // attach u to v

            parent[uParentU] = uParentV;
            size[uParentV] += size[uParentU];
        }else{
            parent[uParentV] = uParentU;
            size[uParentU] += size[uParentV];
        }
    }
}