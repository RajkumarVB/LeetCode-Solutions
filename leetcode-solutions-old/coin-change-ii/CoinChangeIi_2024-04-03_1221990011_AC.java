class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length; 
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr,0); 
        }

        for(int am =0; am<=amount; am++){
            if(am % coins[0] == 0) dp[0][am] = 1; 
        }
        for(int i=1; i<n; i++){
            for(int am =0; am<=amount; am++){
                int notTake = dp[i-1][am]; 
                int take =0; 
                if(amount >= coins[i]){
                    take = (am-coins[i] >= 0 ) ? dp[i][am-coins[i]] : 0;
                }
                dp[i][am] = notTake + take; 
            }
        }
        return dp[n-1][amount]; 
    }
}