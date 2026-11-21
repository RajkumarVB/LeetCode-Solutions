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
 * Approach:    Bottom-up table, obstacles are 0
 * Complexity:  time O(m*n), space O(m*n)
 * Also see:    _2: Top-down memo
 * Submitted:   2024-01-16 (submission 1147979208, AC)
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; 
        int n = obstacleGrid[0].length; 
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n ; j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] =0;
                else if(i ==0 && j==0) dp[i][j] =1; 
                else {
                    int up = 0; 
                    int left =0; 
                    up = i > 0 ? dp[i-1][j] : 0; 
                    left = j > 0 ? dp[i][j-1] : 0; 
                    dp[i][j] = up + left; 
                }
            }
        }

        return dp[m-1][n-1];
    }
}