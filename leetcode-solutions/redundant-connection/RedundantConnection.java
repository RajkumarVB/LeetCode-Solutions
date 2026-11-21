/*
 * 684. Redundant Connection  [Medium]
 * https://leetcode.com/problems/redundant-connection/
 * Topics: Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
 *
 * Problem:     A tree with one extra edge added is given as an edge list. Return the edge
 *              whose removal restores a tree (the last such edge in the input).
 * Example:     [[1,2],[1,3],[2,3]] -> [2,3]
 * Constraints: n <= 1000
 *
 * Key idea:    Union-find: process edges in order. The first edge whose endpoints already
 *              share a root closes a cycle, so it's the redundant one.
 *
 * Approach:    Union-find (union by size + path compression)
 * Complexity:  time O(n * alpha(n)), space O(n)
 * Submitted:   2026-01-23 (submission 1894129889, AC)
 */

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int nodes = edges.length; 
        DisjointSet ds = new DisjointSet(nodes);
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(ds.findParent(u) == ds.findParent(v)){
                return edge; 
            }else{
                ds.union(u,v);
            }
        }
        return new int[]{-1, -1};
    }
}


class DisjointSet{

    private int[] parent; 
    private int[] size; 
    private int n; 

    public DisjointSet(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for(int i=0; i<=n ; i++){
            parent[i] = i; 
            size[i] = 1 ;
        }

    }

    public void union(int u, int v){
        int uParentU = findParent(u);
        int uParentV = findParent(v);

        if(uParentU == uParentV) return; 
        if(size[uParentU] <= size[uParentV]){
            parent[uParentU] = uParentV; 
            size[uParentV] += size[uParentU];
        }else{
            parent[uParentV] = uParentU; 
            size[uParentU] += size[uParentV];
        }

    }

    public int findParent(int u){
        if(parent[u] == u) return u; 
        return parent[u] = findParent(parent[u]); // path compression -> 4 alpha TC
    }

}