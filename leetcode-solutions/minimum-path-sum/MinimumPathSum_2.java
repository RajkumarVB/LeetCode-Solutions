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
 * Approach:    Top-down memo
 * Complexity:  time O(m*n), space O(m*n)
 * Also see:    _1: Bottom-up with a rolling row
 * Submitted:   2024-01-16 (submission 1148071248, AC)
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        int[][] dp = new int[m][n]; 
        for(int[] arr : dp){
            Arrays.fill(arr, -1); 
        }
        return solve(m-1, n-1, grid,dp); 
    }

    public int solve(int i, int j, int[][] grid,int[][] dp){
        if(i == 0 && j ==0) return grid[0][0]; 
        if(i<0 || j <0) return Integer.MAX_VALUE; 
        if(dp[i][j] != -1) return dp[i][j];
        int up = solve(i-1,j, grid,dp);
        int left = solve(i, j-1, grid,dp);
        return dp[i][j] = grid[i][j] + Math.min(up,left); 
    }
}