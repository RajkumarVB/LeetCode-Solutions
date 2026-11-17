class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount+1]; 
        
        for(int am =0; am <= amount; am++){
            if(am % coins[0] == 0) dp[0][am] = am / coins[0];
            else dp[0][am] = (int) Math.pow(10,9); 
        }
        for(int i=1; i<n; i++){
            for(int am =0; am <= amount; am++){
                
                int notTake = dp[i-1][am]; 
                int take = (int) Math.pow(10,9); 
                if(am >= coins[i]){
                    take = 1 + dp[i][am-coins[i]]; 
                }
                dp[i][am] = Math.min(notTake, take);
            }
        }
        if(dp[n-1][amount] >= Math.pow(10,9)) return -1; 
        return dp[n-1][amount]; 
    }
}