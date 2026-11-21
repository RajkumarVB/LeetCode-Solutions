/*
 * 63. Unique Paths II  [Medium]
 * https://leetcode.com/problems/unique-paths-ii/
 * Topics: Array, Dynamic Programming, Matrix
 *
 * Problem:     Unique Paths, but some cells are obstacles that can't be used.
 * Example:     [[0,0,0],[0,1,0],[0,0,0]] -> 2
 * Constraints: up to 100 x 100
 *
 * Key idea:    Same recurrence, but an obstacle cell has 0 paths. Be careful with the first
 *              row and column: after an obstacle, the rest of that row or column is 0.
 *
 * Approach:    Top-down memo
 * Complexity:  time O(m*n), space O(m*n)
 * Also see:    _1: Bottom-up table, obstacles are 0
 * Submitted:   2024-01-16 (submission 1147976927, AC)
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; 
        int n = obstacleGrid[0].length; 
        int[][] dp = new int[m][n];

        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return solve(m-1, n-1, obstacleGrid,dp);
    }
    public int solve(int i, int j, int[][] obstacleGrid, int[][] dp){
        if(i >=0 && j>=0 && obstacleGrid[i][j] == 1) return 0; 
        if(i ==0 && j==0 ) return 1; 
        if(i < 0 || j <0 ) return 0; 
        if(dp[i][j] != -1) return dp[i][j]; 
        int up = solve(i-1, j, obstacleGrid,dp);
        int left = solve(i, j-1, obstacleGrid,dp);
        return dp[i][j] = up + left ;
    }
}