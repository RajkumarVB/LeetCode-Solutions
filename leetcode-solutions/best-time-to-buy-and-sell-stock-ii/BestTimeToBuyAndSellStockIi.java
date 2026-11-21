/*
 * 122. Best Time to Buy and Sell Stock II  [Medium]
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Topics: Array, Dynamic Programming, Greedy
 *
 * Problem:     Same prices array, but you may buy and sell as many times as you like
 *              (holding at most one share). Return the maximum profit.
 * Example:     [7,1,5,3,6,4] -> 7 (1->5 and 3->6)
 * Constraints: 1 <= n <= 3e4
 *
 * Key idea:    Greedy: every upward step prices[i+1] > prices[i] can be captured, so sum
 *              all positive day-to-day differences.
 *
 * Approach:    Sum of positive differences
 * Complexity:  time O(n), space O(1)
 * Submitted:   2024-01-03 (submission 1135501891, AC)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int result = 0; 
        for(int i=0; i<prices.length-1; i++){
            if(prices[i] < prices[i+1]) {
                result += prices[i+1] - prices[i]; 
            }
        }
        return result; 
    }
}