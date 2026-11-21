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
 * Approach:    BFS flood fill counting area
 * Complexity:  time O(m*n), space O(m*n)
 * Also see:    _1: DFS flood fill returning area
 * Submitted:   2026-01-19 (submission 1890028003, AC)
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
                    int area = bfs(grid, i, j, visited);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea; 
    }

    record Point(int i , int j){

    }

    private int bfs(int[][] grid, int i, int j, boolean[][] visited){
        int m= grid.length;
        int n= grid[0].length; 

        LinkedList<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        visited[i][j] = true; 

        int[][] directions = new int[][] {{-1,0}, {0,1}, {0,-1}, {1,0}};
        int area = 0; 
        while(!q.isEmpty()){
            Point p = q.removeFirst();
            area += 1; 
            for(int[] dir : directions){
                int newX = p.i + dir[0];
                int newY = p.j + dir[1];

                if(newX < m && newX >=0 && newY >=0 && newY <n && visited[newX][newY] == false && grid[newX][newY] == 1){
                    q.addLast(new Point(newX, newY));
                    visited[newX][newY] = true; 
                }
            }
        }
        return area; 
    }
}