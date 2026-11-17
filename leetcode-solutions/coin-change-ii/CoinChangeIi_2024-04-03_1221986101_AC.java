class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length; 
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1); 
        }
        return findWays(n-1, amount, coins, dp); 
    }
    public int findWays(int i, int amount, int[] coins, int[][] dp){
        if(amount ==0) return 1; 
        if(i ==0) {
            if(amount % coins[0] == 0) return 1; 
            return 0; 
        }
        if(dp[i][amount] != -1) return dp[i][amount]; 
        int notTake = findWays(i-1,amount,coins,dp); 
        int take =0; 
        if(amount >= coins[i]){
            take = findWays(i,amount - coins[i], coins,dp);
        }
        return dp[i][amount] = notTake + take; 
    }
}