/*
 * 1092. Shortest Common Supersequence   [Hard]
 * https://leetcode.com/problems/shortest-common-supersequence/
 * Topics: String, Dynamic Programming, Longest Common Subsequence
 *
 * Problem:     Return the shortest string that has both str1 and str2 as subsequences.
 * Example:     "abac", "cab" -> "cabac"
 * Constraints: lengths <= 1000
 *
 * Key idea:    Build the LCS table, then walk back from (n, m): on a match emit the
 *              character once; otherwise emit the character from the side you step away
 *              from. Add leftovers and reverse. Length = n + m - LCS.
 *
 * Approach:    LCS table + backtrack to build string
 * Complexity:  time O(n*m), space O(n*m)
 * Submitted:   2024-01-20 (submission 1151741421, AC)
 */

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length(); 

        int[][] dp = new int[n+1][m+1]; 
        for(int i=1; i<= n ;i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        int i, j; 
        i = n;
        j = m; 
        StringBuilder result = new StringBuilder(); 
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                result.append(str1.charAt(i-1));
                i--;
                j--; 
            } else{
                if(dp[i-1][j] > dp[i][j-1]){
                    result.append(str1.charAt(i-1));
                    i--; 
                } else{
                    result.append(str2.charAt(j-1));
                    j--; 
                }
            }
        }
        while(i>0){
            result.append(str1.charAt(i-1));
            i--; 
        }

        while(j>0){
            result.append(str2.charAt(j-1));
            j--; 
        }

        return result.reverse().toString(); 
    }
}