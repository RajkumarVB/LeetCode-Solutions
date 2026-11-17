class Solution {
    public int maxProfit(int[] prices) {
        int resultMaxProfit = 0 ; 
        int n = prices.length; 
        int minCostPrice = prices[0];
        for(int i =0; i<n; i++){
            int profit = prices[i] - minCostPrice; 
            resultMaxProfit = Math.max(resultMaxProfit,profit);
            minCostPrice = Math.min(minCostPrice,prices[i]);
        }
        return resultMaxProfit; 
    }
}