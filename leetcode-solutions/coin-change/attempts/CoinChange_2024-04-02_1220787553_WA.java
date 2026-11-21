class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount+1]; 
        for(int[] arr : dp){
            Arrays.fill(arr,-1); 
        }

        int result = minCoins(n-1,amount, coins,dp);

        if(result >= Math.pow(10,9)) return -1; 
        return result; 
    }
    public int minCoins(int i, int amount, int[] coins, int[][] dp){
        if(i == 0){
            if(amount % coins[0] == 0) return amount / coins[0]; 
            return (int) Math.pow(10,9);
        }
        if(dp[i][amount] != -1) return dp[i][amount]; 
        
        int notTake = minCoins(i-1,amount,coins,dp); 
        int take = Integer.MAX_VALUE; 
        if(amount > coins[i]){
            take = 1 + minCoins(i,amount-coins[i],coins,dp); 
        }
        return dp[i][amount] = Math.min(notTake, take); 
    }
}