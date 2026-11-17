class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length; 
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return noOfWays(n - 1, amount, coins, dp);
    }

    public int noOfWays(int idx, int amount, int[] coins, int[][] dp){
        // base case 
        if(idx ==0){
            if(amount % coins[idx] ==0 ){
                return 1;
            }
            return 0; 
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];

        int notTakeCase = noOfWays(idx -1, amount, coins, dp);

        // take 
        int takeCase = 0;
        if(amount >= coins[idx]){
            takeCase = noOfWays(idx, amount-coins[idx], coins, dp);
        }
        return dp[idx][amount] = notTakeCase + takeCase;
    }
}