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