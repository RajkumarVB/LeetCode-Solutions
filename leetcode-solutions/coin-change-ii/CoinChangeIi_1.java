/*
 * 518. Coin Change II  [Medium]
 * https://leetcode.com/problems/coin-change-ii/
 * Topics: Array, Dynamic Programming, Knapsack Problem, Complete Knapsack
 *
 * Problem:     Count the number of combinations (order doesn't matter) of unlimited coins
 *              that sum to amount.
 * Example:     amount=5, coins=[1,2,5] -> 4
 * Constraints: amount <= 5000, <= 300 coins
 *
 * Key idea:    Counting version of unbounded knapsack: ways(i, a) = ways(i-1, a) + ways(i,
 *              a - coins[i]). Iterating coins in the outer loop counts combinations, not
 *              permutations.
 *
 * Approach:    Top-down memo (take / not take)
 * Complexity:  time O(n * amount), space O(n * amount)
 * Also see:    _2: Bottom-up 2-D tabulation
 * Submitted:   2026-01-02 (submission 1871335405, AC)
 */

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length; 
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return noOfWays(n - 1, amount, coins, dp);
    }

    public int noOfWays(int idx, int amount, int[] coins, int[][] dp){
        // base case 
        if(idx ==0){
            if(amount % coins[idx] ==0 ){
                return 1;
            }
            return 0; 
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];

        int notTakeCase = noOfWays(idx -1, amount, coins, dp);

        // take 
        int takeCase = 0;
        if(amount >= coins[idx]){
            takeCase = noOfWays(idx, amount-coins[idx], coins, dp);
        }
        return dp[idx][amount] = notTakeCase + takeCase;
    }
}