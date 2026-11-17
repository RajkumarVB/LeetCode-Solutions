class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length; 
        if(n <1) return 0; 
        int minSoFar = prices[0];
        int result = 0; 
        for(int i=1; i<n; i++){
            int profit = prices[i] - minSoFar; 
            result = Math.max(result, profit);
            minSoFar = Math.min(minSoFar,prices[i]);
        }
        return result; 
    }
}