/*
 * 139. Word Break  [Medium]
 * https://leetcode.com/problems/word-break/
 * Topics: Array, Hash Table, String, Dynamic Programming, Trie, Memoization, Brute-Force
 *         Search
 *
 * Problem:     Can s be split into a sequence of dictionary words (reuse allowed)?
 * Example:     "leetcode", [leet, code] -> true
 * Constraints: |s| <= 300, <= 1000 words
 *
 * Key idea:    dp[i] = true if some word matches s starting at i and dp[i + len] is true;
 *              dp[n] = true. Fill from right to left (or memoise the recursion).
 *
 * Approach:    Top-down memo
 * Complexity:  time O(n * words * L), space O(n)
 * Also see:    _1: Bottom-up dp from the right
 * Submitted:   2024-04-03 (submission 1221798585, AC)
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(); 
        int[] dp = new int[n];
        Arrays.fill(dp,-1); 
        return isPossible(0,s,wordDict,dp);
    }
    public boolean isPossible(int start, String s, List<String> wordDict,int[] dp){
        int n = s.length(); 
        if(start >=n) return true; 
        if(dp[start] ==0 ) return false; 
        if(dp[start] == 1)  return true; 
        for(String word : wordDict){
            int wLen = word.length(); 
            if(start + wLen <= n && s.substring(start, start+wLen).equals(word)){
                if(isPossible(start+wLen, s, wordDict,dp)){
                    dp[start] = 1; 
                    return true; 
                }
            }
        }
        dp[start] = 0; 
        return false; 
    }
}