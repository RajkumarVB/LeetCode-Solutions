/*
 * 91. Decode Ways  [Medium]
 * https://leetcode.com/problems/decode-ways/
 * Topics: String, Dynamic Programming
 *
 * Problem:     Digits map to letters (1->A ... 26->Z). Count the ways to decode a digit
 *              string.
 * Example:     "226" -> 3 (2 2 6, 22 6, 2 26)
 * Constraints: n <= 100, may contain zeros
 *
 * Key idea:    ways(i) = ways(i+1) if s[i] != '0', plus ways(i+2) if s[i..i+1] is between
 *              10 and 26. A '0' can never start a code.
 *
 * Approach:    Top-down memo over index
 * Complexity:  time O(n), space O(n)
 * Submitted:   2024-04-02 (submission 1220752426, AC)
 */

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n]; 
        Arrays.fill(dp,-1); 
        return noOfWays(s,0,n,dp); 
    }
    public int noOfWays(String s, int i, int n, int[] dp){
        if(i>=n) return 1; 
        if(dp[i] != -1) return dp[i]; 
        char first = s.charAt(i); 
        int result = 0; 
        if(first != '0') result += noOfWays(s,i+1,n,dp); 
        if(i + 1 < n){
            char second = s.charAt(i+1); 
            if(first == '1' || first == '2' && (second >='0' && second <= '6')){
                result += noOfWays(s,i+2,n,dp); 
            }
        }
        return dp[i] = result; 
    }
}