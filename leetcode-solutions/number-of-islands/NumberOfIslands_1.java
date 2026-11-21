/*
 * 200. Number of Islands  [Medium]
 * https://leetcode.com/problems/number-of-islands/
 * Topics: Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
 *
 * Problem:     Count the islands (4-directionally connected groups of '1') in a grid.
 * Example:     a grid with 3 separate land blobs -> 3
 * Constraints: up to 300 x 300
 *
 * Key idea:    Scan the grid; each unvisited land cell starts a new island. Flood-fill it
 *              (DFS or BFS) so its cells aren't counted again. Mark cells visited when you
 *              enqueue them, not when you dequeue.
 *
 * Approach:    DFS flood fill
 * Complexity:  time O(m*n), space O(m*n)
 * Also see:    _2: BFS flood fill (mark on enqueue)
 * Submitted:   2025-12-26 (submission 1865579503, AC)
 */

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 

        boolean[][] visited = new boolean[m][n]; 
        int noOfIslands = 0; 
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    dfs(i,j,grid, visited); 
                    noOfIslands++; 
                }
            }
        }
        return noOfIslands; 
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited){
        int m = grid.length; 
        int n = grid[0].length;


        if(i < 0 || i >=m || j<0 || j>=n || grid[i][j] == '0' || visited[i][j] == true) return; 

        visited[i][j] = true; 
        dfs(i+1,j, grid, visited);
        dfs(i,j+1, grid, visited);
        dfs(i-1,j, grid, visited);
        dfs(i,j-1, grid, visited);
    }
}