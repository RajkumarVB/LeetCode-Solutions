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
 * Approach:    Bottom-up with two rolling rows
 * Complexity:  time O(n*m), space O(m)
 * Also see:    _2: Top-down memo
 * Submitted:   2025-04-05 (submission 1596915126, AC)
 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(); 
        int n2 = text2.length(); 

        int[] prev = new int[n2+1]; 

        for(int i=1; i<=n1; i++){
            int[] curr = new int[n2+1]; 
            for(int j=1; j<=n2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = Math.max(curr[j-1], prev[j]); 
                }
            }
            prev = curr; 
        }
        return prev[n2]; 
    }

}