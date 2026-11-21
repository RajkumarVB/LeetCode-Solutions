/*
 * 1091. Shortest Path in Binary Matrix  [Medium]
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * Topics: Array, Breadth-First Search, Matrix
 *
 * Problem:     Return the length of the shortest path of 0-cells from top-left to bottom-
 *              right, moving in 8 directions, or -1.
 * Example:     [[0,1],[1,0]] -> 2
 * Constraints: n <= 100
 *
 * Key idea:    Unweighted shortest path means BFS. The first time you reach a cell is its
 *              shortest distance. Check that the start and end cells are 0.
 *
 * Approach:    BFS with distance array, 8 directions
 * Complexity:  time O(n^2), space O(n^2)
 * Submitted:   2024-04-15 (submission 1232449550, AC)
 */

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        if(grid[0][0] == 1) return -1; 
        if(m ==1 && n ==1) return 1; 
        int[][] dist = new int[m][n];
        for(int[] arr : dist){
            Arrays.fill(arr,Integer.MAX_VALUE); 
        }
        dist[0][0] = 0; // src 

        Queue<Point> q = new LinkedList<>(); 
        q.offer(new Point(0,0,1));
        int[] delX = new int[]{-1,0,1};
        int[] delY = new int[]{-1,0,1};
        while(!q.isEmpty()){
            Point p = q.poll(); 
            for(int delx : delX){
                for(int dely: delY){
                    if(delx ==0 && dely ==0) continue; 
                    int x = p.x + delx; 
                    int y = p.y + dely; 
                    if(x >=0 && x<m && y >=0 && y<n && grid[x][y] == 0 && (1 + p.dist) < dist[x][y]){
                        dist[x][y] = 1 + p.dist; 
                        q.offer(new Point(x,y,dist[x][y])); 
                    }
                }
            }
        }
        return (dist[m-1][n-1] != Integer.MAX_VALUE) ? dist[m-1][n-1] : -1; 

    }
    record Point(int x, int y, int dist){

    }
}