/*
 * 121. Best Time to Buy and Sell Stock  [Easy]
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Topics: Array, Dynamic Programming
 *
 * Problem:     Given daily prices, choose one day to buy and a later day to sell to
 *              maximise profit. Return 0 if no profit is possible.
 * Example:     [7,1,5,3,6,4] -> 5 (buy at 1, sell at 6)
 * Constraints: 1 <= n <= 1e5
 *
 * Key idea:    Scan once, tracking the minimum price seen so far; the best profit when
 *              selling today is price - minSoFar.
 *
 * Approach:    Single pass with running minimum
 * Complexity:  time O(n), space O(1)
 * Submitted:   2025-09-13 (submission 1769684631, AC)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length; 
        int maxProfit = 0;
        int minStockPriceSoFar = prices[0];  
        for(int i=1; i<n; i++){
           int profit =0; 
           profit = Math.max(profit, prices[i] - minStockPriceSoFar); 
           maxProfit = Math.max(profit, maxProfit);
           minStockPriceSoFar = Math.min(minStockPriceSoFar, prices[i]);       
        }
        return maxProfit; 
    }
}