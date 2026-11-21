/*
 * 994. Rotting Oranges  [Medium]
 * https://leetcode.com/problems/rotting-oranges/
 * Topics: Array, Breadth-First Search, Matrix
 *
 * Problem:     Each minute, fresh oranges next to rotten ones rot. Return the minutes until
 *              none are fresh, or -1 if some never rot.
 * Example:     [[2,1,1],[1,1,0],[0,1,1]] -> 4
 * Constraints: up to 10 x 10
 *
 * Key idea:    Multi-source BFS: put every initially rotten orange in the queue at time 0.
 *              Each BFS layer is one minute. Count fresh oranges and compare with how many
 *              got rotted.
 *
 * Approach:    Multi-source BFS with time stored in the queue
 * Complexity:  time O(m*n), space O(m*n)
 * Submitted:   2025-12-28 (submission 1867700983, AC)
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        
        boolean[][] visited = new boolean[m][n]; 
        Queue<Pair> q = new LinkedList<>(); 
        int noOfFreshOranges = 0; 
        int newlyRottenedOranges = 0; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i, j, 0)); 
                    visited[i][j] = true; 
                }else if(grid[i][j] == 1){
                    noOfFreshOranges++; 
                }
            }
        }


        int maxTime = 0; 

        int[][] directions = new int[][] {{-1,0}, {1,0}, {0,-1}, {0, 1}}; // up down left right
        while(!q.isEmpty()){
            Pair p = q.poll(); 
            int x = p.x; 
            int y = p.y; 
            int time = p.time; 
            maxTime = Math.max(maxTime, time); 

            for(int[] dir : directions){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >=0 && newX <m && newY >=0 && newY <n && visited[newX][newY] == false && 
                    grid[newX][newY] == 1
                ){
                        newlyRottenedOranges ++; 
                        visited[newX][newY] = true; 
                        q.offer(new Pair(newX, newY, time +1)); 
                }

            }
        }
        
        if(newlyRottenedOranges != noOfFreshOranges) return -1; 
        return maxTime; 
    }

    record Pair(int x, int y, int time){

    }
}

// At the end, no of rotten oranges == no of fresh oranges!! 
// else return -1; 
// 


// I'll run a BFS starting from all the rotten oranges; 
// I'll keep track of time and update the max time
// I'll also keep track of no of fresh oranges that have rottened! 