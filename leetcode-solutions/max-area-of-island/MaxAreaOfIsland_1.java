/*
 * 695. Max Area of Island  [Medium]
 * https://leetcode.com/problems/max-area-of-island/
 * Topics: Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
 *
 * Problem:     Return the area of the largest 4-directionally connected island of 1s in a
 *              grid.
 * Example:     grid with islands of size 4, 6, 3 -> 6
 * Constraints: up to 50 x 50
 *
 * Key idea:    Flood-fill each unvisited land cell (DFS or BFS) and count the cells
 *              reached; keep the maximum.
 *
 * Approach:    DFS flood fill returning area
 * Complexity:  time O(m*n), space O(m*n)
 * Also see:    _2: BFS flood fill counting area
 * Submitted:   2026-01-19 (submission 1890039662, AC)
 */

class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 

        boolean[][] visited = new boolean[m][n];
        int maxArea = 0; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    int area = computeIslandArea(grid, i, j, visited);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea; 
    }

    private int computeIslandArea(int[][] grid, int i, int j, boolean[][] visited){
        int m = grid.length; 
        int n = grid[0].length; 
        if(i <0 || i>=m || j<0 || j>=n || visited[i][j] == true || grid[i][j] == 0){
            return 0; 
        } 
        visited[i][j] = true; 

        int[][] directions = new int[][] {{-1,0}, {1,0}, {0,1}, {0,-1}};
        int area = 0; 
        for(int[] dir : directions){
            int newX = i + dir[0];
            int newY = j + dir[1];
            area += computeIslandArea(grid, newX, newY, visited);
        }
        return 1 + area; 

    }

    
}