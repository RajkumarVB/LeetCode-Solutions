class Solution {
    
    public int change(int amount, int[] coins) {
        int n = coins.length; 
        int[][]dp = new int[n][amount+1];
        
        for(int index =0; index <n; index++){
            dp[index][0] = 1; 
        }

        for(int j=1; j<= amount; j++){
            dp[0][j] = (amount % coins[0] ==0) ? 1 : 0; 
        }

        // j-> amount
        for(int index =1; index<n; index++){
            for(int j=1; j<= amount; j++){
                int take = 0; 
                if(j >= coins[index]){
                    take = dp[index][j - coins[index]]; 
                }
                int notTake = 0; 
                notTake = dp[index-1][j]; 
                dp[index][j] = take + notTake; 

            }
        }
        return dp[n-1][amount]; 
    }
}