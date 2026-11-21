/*
 * 1143. Longest Common Subsequence  [Medium]
 * https://leetcode.com/problems/longest-common-subsequence/
 * Topics: String, Dynamic Programming, Longest Common Subsequence
 *
 * Problem:     Return the length of the longest common subsequence of two strings.
 * Example:     "abcde", "ace" -> 3
 * Constraints: lengths <= 1000
 *
 * Key idea:    f(i, j) = 1 + f(i-1, j-1) if chars match, else max(f(i-1, j), f(i, j-1)).
 *              The base pattern for many string DPs (edit distance, delete operations,
 *              palindromic subsequence).
 *
 * Approach:    Top-down memo
 * Complexity:  time O(n*m), space O(n*m)
 * Also see:    _1: Bottom-up with two rolling rows
 * Submitted:   2025-04-05 (submission 1596909104, AC)
 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(); 
        int n2 = text2.length(); 
        int[][] dp = new int[n1][n2]; 

        for(int[] arr: dp){
            Arrays.fill(arr, -1); 
        }

        return lcs(text1, text2, n1-1, n2-1, dp); 
    }

    private int lcs(String s1, String s2, int i, int j, int[][]dp){
        if(i < 0 || j <0) return 0; 
        
        if(dp[i][j] != -1) return dp[i][j]; 

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + lcs(s1,s2,i-1,j-1,dp); 
        }

        return dp[i][j] = Math.max(lcs(s1,s2,i-1,j,dp), lcs(s1,s2,i,j-1,dp)); 
    }
}