/*
 * 62. Unique Paths  [Medium]
 * https://leetcode.com/problems/unique-paths/
 * Topics: Math, Dynamic Programming, Combinatorics
 *
 * Problem:     A robot moves only right or down on an m x n grid. Count the paths from the
 *              top-left to the bottom-right.
 * Example:     m=3, n=7 -> 28
 * Constraints: m, n <= 100
 *
 * Key idea:    paths(i, j) = paths(i-1, j) + paths(i, j-1), with the first row and column
 *              all 1. Math shortcut: C(m+n-2, m-1).
 *
 * Approach:    Bottom-up 2-D table
 * Complexity:  time O(m*n), space O(m*n)
 * Also see:    _1: Top-down memo
 * Submitted:   2024-04-03 (submission 1221966910, AC)
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; 
        for(int i=0; i<m; i++){
            dp[i][0] = 1; 
        }
        for(int j=0; j<n; j++){
            dp[0][j] = 1; 
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
            }
        }
        return dp[m-1][n-1]; 
    }
}