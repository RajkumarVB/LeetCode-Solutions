/*
 * 72. Edit Distance  [Medium]
 * https://leetcode.com/problems/edit-distance/
 * Topics: String, Dynamic Programming
 *
 * Problem:     Return the minimum number of single-character inserts, deletes or replaces
 *              needed to turn word1 into word2.
 * Example:     "horse", "ros" -> 3
 * Constraints: lengths <= 500
 *
 * Key idea:    f(i, j): if chars match, f(i-1, j-1); else 1 + min(insert f(i, j-1), delete
 *              f(i-1, j), replace f(i-1, j-1)). Base: f(i,0)=i, f(0,j)=j.
 *
 * Approach:    Bottom-up 2-D tabulation
 * Complexity:  time O(m*n), space O(m*n)
 * Also see:    _1: Top-down memo; _3: Two rolling rows
 * Submitted:   2024-04-09 (submission 1227718812, AC)
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            dp[i][0] = i; 
        }
        for(int j=0; j<=n; j++){
            dp[0][j] = j; 
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]; 
                } else{
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1]; 
                    dp[i][j] = Math.min(Math.min(insert,delete),replace); 
                }
            }
        }
        return dp[m][n];
    }
}