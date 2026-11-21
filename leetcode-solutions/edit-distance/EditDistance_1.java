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
 * Approach:    Top-down memo
 * Complexity:  time O(m*n), space O(m*n)
 * Also see:    _2: Bottom-up 2-D tabulation; _3: Two rolling rows
 * Submitted:   2024-04-09 (submission 1227715203, AC)
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1); 
        }

        return minDistance(m,n,word1,word2,dp);
    }
    public int minDistance(int i, int j, String s1, String s2, int[][] dp){
        if(i == 0) return j;
        if(j == 0) return i; 
        if(dp[i][j] != -1) return dp[i][j]; 
        
        if(s1.charAt(i-1) == s2.charAt(j-1)) return dp[i][j] = minDistance(i-1,j-1,s1,s2,dp); 
        int insert = 1 + minDistance(i,j-1,s1,s2,dp);
        int delete = 1 + minDistance(i-1,j,s1,s2,dp);
        int replace = 1 + minDistance(i-1,j-1,s1,s2,dp); 
        return dp[i][j] = Math.min(Math.min(insert,delete),replace); 
    }
}