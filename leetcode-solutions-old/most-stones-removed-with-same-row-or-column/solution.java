class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length; 
        DisjointSet ds = new DisjointSet(n); 
        for(int i=0; i<n;i++){
            int x1 = stones[i][0];
            int y1 = stones[i][1];

            for(int j =1; j<n; j++){
                int x2 = stones[j][0];
                int y2 = stones[j][1];

                if(x1 == x2 || y1 == y2){
                    ds.unionBySize(i,j); 
                }
            }
        }
        return n - ds.noOfComponents(); 
    }

    static class DisjointSet{
        int[] parent; 
        int[] size; 
        public DisjointSet(int n){
            this.parent = new int[n];
            this.size = new int[n];
            for(int i=0; i<n ;i++){
                parent[i] = i; 
                size[i] =1; 
            }
        }

        public void unionBySize(int u, int v){
            int uParentU = findUParent(u);
            int uParentV = findUParent(v);
            if(uParentU == uParentV) return ; 
            if(size[uParentU] < size[uParentV]){
                parent[uParentU] = uParentV; 
                size[uParentV] += size[uParentU];
            } else{
                parent[uParentV] = uParentU; 
                size[uParentU] += size[uParentV];
            }
        }

        public int findUParent(int u){
            if(parent[u] == u) return u; 
            return parent[u] = findUParent(parent[u]);
        }

        public int noOfComponents(){
            int count = 0; 
            for(int i=0; i<parent.length; i++){
                if(i == parent[i]) count ++; 
            }
            return count; 
        }
    }
}