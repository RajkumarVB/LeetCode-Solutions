/*
 * 583. Delete Operation for Two Strings  [Medium]
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 * Topics: String, Dynamic Programming, Longest Common Subsequence
 *
 * Problem:     Return the minimum number of single-character deletions (from either string)
 *              to make the two strings equal.
 * Example:     "sea", "eat" -> 2
 * Constraints: lengths <= 500
 *
 * Key idea:    Whatever survives is a common subsequence, so keep the longest one: answer =
 *              len1 + len2 - 2 * LCS.
 *
 * Approach:    LCS tabulation
 * Complexity:  time O(n*m), space O(n*m)
 * Submitted:   2024-01-20 (submission 1151709129, AC)
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1, word2); 
        int deletions1 = word1.length() - lcs; 
        int deletions2 = word2.length() - lcs; 
        return deletions1 + deletions2; 
    }
    public int longestCommonSubsequence(String s1, String s2){
        int n = s1.length();
        int m = s2.length(); 
        int[][] dp = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m]; 
    }
}