class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[coins.length];
        Arrays.fill(dp, -1);
        return noOfWays(coins.length - 1, amount, coins, dp);
    }

    public int noOfWays(int idx, int amount, int[] coins, int[] dp){
        // base case 
        if(idx ==0 || amount ==0){
            if(amount % coins[idx] ==0 ){
                return 1;
            }
            return 0; 
        }
        if(dp[idx] != -1) return dp[idx];

        int notTakeCase = noOfWays(idx -1, amount, coins, dp);

        // take 
        int takeCase = 0;
        if(amount >= coins[idx]){
            takeCase = noOfWays(idx, amount-coins[idx], coins, dp);
        }
        return dp[idx] = notTakeCase + takeCase;
    }
}