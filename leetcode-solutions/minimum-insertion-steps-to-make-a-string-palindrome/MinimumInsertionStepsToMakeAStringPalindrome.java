/*
 * 1312. Minimum Insertion Steps to Make a String Palindrome  [Hard]
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * Topics: String, Dynamic Programming
 *
 * Problem:     Return the minimum number of character insertions to make s a palindrome.
 * Example:     "mbadm" -> 2
 * Constraints: n <= 500
 *
 * Key idea:    Keep the longest palindromic subsequence and insert a partner for every
 *              other character: answer = n - LPS = n - LCS(s, reverse(s)).
 *
 * Approach:    n - LCS(s, reverse(s))
 * Complexity:  time O(n^2), space O(n^2)
 * Submitted:   2024-01-20 (submission 1151693520, AC)
 */

class Solution {
    public int minInsertions(String s) {

        // Longest Palindromic Subsequence code. 
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

        return s1.length() - dp[n][m]; 
    }
}