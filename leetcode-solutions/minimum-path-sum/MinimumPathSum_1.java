/*
 * 64. Minimum Path Sum  [Medium]
 * https://leetcode.com/problems/minimum-path-sum/
 * Topics: Array, Dynamic Programming, Matrix
 *
 * Problem:     Moving only right or down, find the minimum-sum path from the top-left to
 *              the bottom-right of a grid.
 * Example:     [[1,3,1],[1,5,1],[4,2,1]] -> 7
 * Constraints: up to 200 x 200
 *
 * Key idea:    dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1]). One row of state is
 *              enough.
 *
 * Approach:    Bottom-up with a rolling row
 * Complexity:  time O(m*n), space O(n)
 * Also see:    _2: Top-down memo
 * Submitted:   2024-01-16 (submission 1148081069, AC)
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        int[][] dp = new int[m][n]; 

        int[] curr = new int[n];
        int[] prev = new int[n];
        
        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j ==0) curr[j] = grid[0][0]; 
                else{
                    int up, left; 
                    up = (i>0) ? prev[j] : Integer.MAX_VALUE;
                    left = (j>0)? curr[j-1] : Integer.MAX_VALUE;  
                    curr[j] = grid[i][j] + Math.min(up,left); 
                }
            }
            prev = curr; 
        }
        return prev[n-1]; 
    }
}