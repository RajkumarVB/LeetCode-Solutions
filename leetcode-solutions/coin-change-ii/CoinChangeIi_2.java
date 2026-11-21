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
 * Approach:    Bottom-up 2-D tabulation
 * Complexity:  time O(n * amount), space O(n * amount)
 * Also see:    _1: Top-down memo (take / not take)
 * Submitted:   2024-01-18 (submission 1149982230, AC)
 */

class Solution {
    
    public int change(int amount, int[] coins) {
        int n = coins.length; 
        int[][]dp = new int[n][amount+1];
        
        for(int index =0; index <n; index++){
            dp[index][0] = 1; 
        }

        for(int j=0; j<= amount; j++){
            dp[0][j] = (j % coins[0] ==0) ? 1 : 0; 
        }

        // j-> amount
        for(int index =1; index<n; index++){
            for(int j=1; j<= amount; j++){
                int take = 0; 
                if(j >= coins[index]){
                    take = dp[index][j - coins[index]]; 
                }
                int notTake = 0; 
                notTake = dp[index-1][j]; 
                dp[index][j] = take + notTake; 

            }
        }
        return dp[n-1][amount]; 
    }
}