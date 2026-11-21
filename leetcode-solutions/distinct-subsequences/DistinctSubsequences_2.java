/*
 * 115. Distinct Subsequences  [Hard]
 * https://leetcode.com/problems/distinct-subsequences/
 * Topics: String, Dynamic Programming
 *
 * Problem:     Count how many distinct subsequences of s equal t.
 * Example:     s="rabbbit", t="rabbit" -> 3
 * Constraints: lengths <= 1000
 *
 * Key idea:    f(i, j) = ways using s[0..i) to form t[0..j). If s[i-1] == t[j-1]: use it
 *              (f(i-1,j-1)) or skip it (f(i-1,j)); else only skip. Base: f(i,0)=1,
 *              f(0,j>0)=0.
 *
 * Approach:    Bottom-up 2-D tabulation
 * Complexity:  time O(n*m), space O(n*m)
 * Also see:    _1: Top-down memo; _3: 1-D array, iterate j backwards
 * Submitted:   2024-01-20 (submission 1151823238, AC)
 */

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(); 
        int m = t.length(); 
        int[][] dp = new int[n+1][m+1]; 
        
        for(int i=0; i<=n; i++) dp[i][0] = 1; 
        for(int j=1; j<=m; j++) dp[0][j] = 0; 
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; 
                } else{
                    dp[i][j] = dp[i-1][j]; 
                }
            }
        }

        return dp[n][m]; 
    }
}