/*
 * 516. Longest Palindromic Subsequence  [Medium]
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * Topics: String, Dynamic Programming
 *
 * Problem:     Return the length of the longest palindromic subsequence of s.
 * Example:     "bbbab" -> 4
 * Constraints: n <= 1000
 *
 * Key idea:    A palindromic subsequence reads the same reversed, so the answer = LCS(s,
 *              reverse(s)).
 *
 * Approach:    LCS of s and its reverse
 * Complexity:  time O(n^2), space O(n^2)
 * Submitted:   2024-01-20 (submission 1151670842, AC)
 */

class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = s; 
        String s2 = new StringBuilder(s1).reverse().toString(); 
        
        // Longest Common Subsequence Code.         
        int n = s1.length();
        int m = s2.length(); 
        int[][] dp = new int[n+1][m+1]; 
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][m]; 
    }
}