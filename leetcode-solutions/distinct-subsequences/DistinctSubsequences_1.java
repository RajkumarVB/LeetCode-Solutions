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
 * Approach:    Top-down memo
 * Complexity:  time O(n*m), space O(n*m)
 * Also see:    _2: Bottom-up 2-D tabulation; _3: 1-D array, iterate j backwards
 * Submitted:   2024-01-20 (submission 1151819589, AC)
 */

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(); 
        int m = t.length(); 
        int[][] dp = new int[n+1][m+1]; 
        
        for(int[] arr : dp) Arrays.fill(arr,-1); 

        return solve(n,m,s,t,dp); 
    }
    public int solve(int i, int j, String s, String t, int[][] dp){
        if(j ==0) return 1; 
        if(i ==0) return 0; 
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i-1) == t.charAt(j-1)){
            return dp[i][j] = solve(i-1,j-1,s,t,dp) + solve(i-1,j,s,t,dp); 
        }
        return dp[i][j] = solve(i-1,j,s,t,dp); 
    }
}