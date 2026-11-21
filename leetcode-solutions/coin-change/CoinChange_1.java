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
 * Approach:    Bottom-up DP, space-optimised to two rows
 * Complexity:  time O(n * amount), space O(amount)
 * Also see:    _2: Top-down memo (take / not take)
 * Submitted:   2024-04-02 (submission 1220799796, AC)
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        

        int[] prev = new int[amount+1];
        
        for(int am =0; am <= amount; am++){
            if(am % coins[0] == 0) prev[am] = am / coins[0];
            else prev[am] = (int) Math.pow(10,9); 
        }

        for(int i=1; i<n; i++){
            int[] curr = new int[amount+1];
            for(int am =0; am <= amount; am++){
                
                int notTake = prev[am]; 
                int take = (int) Math.pow(10,9); 
                if(am >= coins[i]){
                    take = 1 + curr[am-coins[i]]; 
                }
                curr[am] = Math.min(notTake, take);
            }
            prev = curr; 
        }

        if(prev[amount] >= Math.pow(10,9)) return -1; 
        return prev[amount]; 
    }
}