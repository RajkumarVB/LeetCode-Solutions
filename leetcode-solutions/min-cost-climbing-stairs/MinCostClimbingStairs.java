/*
 * 746. Min Cost Climbing Stairs  [Easy]
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * Topics: Array, Dynamic Programming
 *
 * Problem:     Paying cost[i] lets you climb 1 or 2 steps from step i. Starting at step 0
 *              or 1, return the minimum cost to reach the top (just past the last step).
 * Example:     [10,15,20] -> 15
 * Constraints: n <= 1000
 *
 * Key idea:    f(i) = min(f(i-1) + cost[i-1], f(i-2) + cost[i-2]) with f(0) = f(1) = 0.
 *
 * Approach:    Top-down memo
 * Complexity:  time O(n), space O(n)
 * Submitted:   2024-04-01 (submission 1220168666, AC)
 */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length; 
        int[] dp = new int[n+1]; 
        Arrays.fill(dp,-1); 
        return findMinCost(n, cost, dp);
    }
    public int findMinCost(int n, int[] cost, int[] dp){
        if(n < 0) return Integer.MAX_VALUE; 
        if(n ==0 || n==1 ) return dp[n] = 0; 
        if(dp[n] != -1) return dp[n]; 
        return dp[n] = Math.min(findMinCost(n-1,cost,dp) + cost[n-1], findMinCost(n-2,cost,dp) + cost[n-2]); 
    }
}