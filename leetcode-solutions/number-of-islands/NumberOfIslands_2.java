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
 * Approach:    BFS flood fill (mark on enqueue)
 * Complexity:  time O(m*n), space O(min(m,n))
 * Also see:    _1: DFS flood fill
 * Submitted:   2025-03-30 (submission 1590736918, AC)
 */

class Solution {
    private boolean [][] visited; 
    public int numIslands(char[][] grid) {
        int rows = grid.length; 
        int cols = grid[0].length; 
        
        visited = new boolean[rows][cols]; 
        int noOfIslands = 0; 
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(grid, i, j); 
                    noOfIslands ++; 
                }
            }
        }
        return noOfIslands; 
    }

    public void bfs(char[][] grid, int i, int j){
        int rows = grid.length; 
        int cols = grid[0].length; 

        visited[i][j] = true; 
        Queue<Pair> q = new LinkedList<>(); 
        q.offer(new Pair(i, j)); 
        while(!q.isEmpty()){
            Pair p = q.poll(); 
            

            int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
            for(int[] dir : directions){
                int delX = dir[0];
                int delY = dir[1];
                int newX = p.i + delX; 
                int newY = p.j + delY; 

                if(newX >= 0 && newX < rows && newY >=0 && newY < cols && visited[newX][newY] == false
                    && grid[newX][newY] == '1'){
                    visited[newX][newY] = true; 
                    q.offer(new Pair(newX, newY)); 
                }
            }

        }
    }
    class Pair{
        int i; 
        int j; 
        public Pair(int i, int j){
            this.i = i; 
            this.j = j; 
        }
    }
}