/*
 * 1319. Number of Operations to Make Network Connected  [Medium]
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 * Topics: Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
 *
 * Problem:     Move cables between computers to connect the whole network. Return the
 *              minimum number of moves, or -1 if impossible.
 * Example:     n=4, [[0,1],[0,2],[1,2]] -> 1
 * Constraints: n <= 1e5
 *
 * Key idea:    Union-find: every edge joining two already-connected nodes is a spare cable.
 *              With c components you need c-1 cables, so the answer is c-1 if spare >= c-1,
 *              else -1. (Shortcut: if edges < n-1, answer -1.)
 *
 * Approach:    Union-find counting extra edges and components
 * Complexity:  time O(E * alpha), space O(n)
 * Submitted:   2024-01-14 (submission 1145915213, AC)
 */

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int extraEdges =0; 
        DisjointSet ds = new DisjointSet(n);
        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];

            if(ds.findUParent(u) == ds.findUParent(v)){
                extraEdges+=1; 
            } else{
                ds.unionBySize(u,v); 
            }
        }
        int noOfComponents = ds.noOfConnectedComponents(); 
        if(extraEdges >= noOfComponents -1){
            return noOfComponents -1; 
        }
        return -1;
    }
    static class DisjointSet{
        int[] parent; 
        int[] size;
        
        public DisjointSet(int n){
            this.parent = new int[n];
            this.size = new int[n];

            for(int i=0; i<n; i++){
                parent[i] =i; 
                size[i] =1; 
            }
        }

        public int findUParent(int u){
            if(parent[u] == u) return u; 
            return parent[u] = findUParent(parent[u]);
        }

        public void unionBySize(int u, int v){
            int uParentU = findUParent(u);
            int uParentV = findUParent(v);
            if(uParentU == uParentV) return; 
            if(size[u] < size[v]){
                parent[uParentU] = uParentV; 
                size[uParentV] += size[uParentU]; 
            } else{
                parent[uParentV] = uParentU; 
                size[uParentU] += size[uParentV]; 
            }
        }

        public int noOfConnectedComponents(){
            int count =0; 
            for(int i=0; i<parent.length; i++){
                if(parent[i] == i){
                    count++; 
                }
            }
            return count; 
        }
    }
}