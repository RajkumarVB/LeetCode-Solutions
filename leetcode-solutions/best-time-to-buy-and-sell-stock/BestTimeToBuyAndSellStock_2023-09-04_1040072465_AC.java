class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int n = prices.length; 
        int result = 0; 
        for(int i= 1; i<n ; i++){
            if(prices[i] - minSoFar >0) result = Math.max(result,prices[i] - minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return result; 
    }
}