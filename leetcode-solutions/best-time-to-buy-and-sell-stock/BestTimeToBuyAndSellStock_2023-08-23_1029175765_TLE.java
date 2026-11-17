class Solution {
    public int maxProfit(int[] prices) {
        int resultMaxProfit = 0 ; 
        int n = prices.length; 
        for(int i =0; i<n; i++){
            for(int j =i+1; j<n ;j++){
                int profit = prices[j] - prices[i]; 
                resultMaxProfit = Math.max(resultMaxProfit,profit); 
            }
        }
        return resultMaxProfit; 
    }
}