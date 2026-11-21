/*
 * 70. Climbing Stairs  [Easy]
 * https://leetcode.com/problems/climbing-stairs/
 * Topics: Math, Dynamic Programming, Memoization
 *
 * Problem:     You climb n stairs taking 1 or 2 steps at a time. How many distinct ways
 *              reach the top?
 * Example:     n=3 -> 3 (1+1+1, 1+2, 2+1)
 * Constraints: 1 <= n <= 45
 *
 * Key idea:    ways(n) = ways(n-1) + ways(n-2): it's Fibonacci. Memoise the recursion, or
 *              keep just two variables.
 *
 * Approach:    Top-down recursion + memo array
 * Complexity:  time O(n), space O(n)
 * Submitted:   2024-04-01 (submission 1220142463, AC)
 */

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1]; 
        Arrays.fill(dp,-1); 
        return noOfWays(n,dp); 
    }
    public int noOfWays(int n, int[] dp){
        if(n==0) return 1; 
        if(n < 0) return 0; 
        if(dp[n] != -1) return dp[n]; 
        return dp[n] = noOfWays(n-1,dp) + noOfWays(n-2,dp); 
    }
}