/*
 * 322. Coin Change  [Medium]
 * https://leetcode.com/problems/coin-change/
 * Topics: Array, Dynamic Programming, Breadth-First Search, Knapsack Problem, Complete
 *         Knapsack
 *
 * Problem:     Given coin denominations (unlimited supply) and an amount, return the fewest
 *              coins that make the amount, or -1.
 * Example:     coins=[1,2,5], amount=11 -> 3 (5+5+1)
 * Constraints: amount <= 1e4, <= 12 coins
 *
 * Key idea:    Unbounded knapsack: for coin i either skip it (i-1) or take it and stay at
 *              i. Use a big sentinel (1e9) for impossible. 1-D form: dp[a] = min(dp[a], 1 +
 *              dp[a - coin]).
 *
 * Approach:    Top-down memo (take / not take)
 * Complexity:  time O(n * amount), space O(n * amount)
 * Also see:    _1: Bottom-up DP, space-optimised to two rows
 * Submitted:   2024-04-02 (submission 1220789601, AC)
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount+1]; 
        for(int[] arr : dp){
            Arrays.fill(arr,-1); 
        }

        int result = minCoins(n-1,amount, coins,dp);

        if(result >= Math.pow(10,9)) return -1; 
        return result; 
    }
    public int minCoins(int i, int amount, int[] coins, int[][] dp){
        if(i == 0){
            if(amount % coins[0] == 0) return amount / coins[0]; 
            return (int) Math.pow(10,9);
        }
        if(dp[i][amount] != -1) return dp[i][amount]; 

        int notTake = minCoins(i-1,amount,coins,dp); 
        int take = (int) Math.pow(10,9); 
        if(amount >= coins[i]){
            take = 1 + minCoins(i,amount-coins[i],coins,dp); 
        }
        return dp[i][amount] = Math.min(notTake, take); 
    }
}