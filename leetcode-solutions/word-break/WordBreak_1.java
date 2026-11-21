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
 * Approach:    Bottom-up dp from the right
 * Complexity:  time O(n * words * L), space O(n)
 * Also see:    _2: Top-down memo
 * Submitted:   2024-04-03 (submission 1221805613, AC)
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(); 
        int[] dp = new int[n+1];
        dp[n] = 1; 
        
        for(int start=n-1; start>=0; start--){
            for(String word : wordDict){
                int wLen = word.length(); 
                if(start + wLen <= n && s.substring(start, start+wLen).equals(word)){
                    dp[start] = dp[start+wLen]; 
                }
                if(dp[start] == 1) break; 
            }   
        }
        return dp[0] ==1; 
    }
}