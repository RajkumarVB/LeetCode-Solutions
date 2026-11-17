class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1]; 
        Arrays.fill(dp,-1); 
        return noOfWays(n,dp); 
    }
    public int noOfWays(int n, int[] dp){
        if(n==0) return 1; 
        if(n < 0) return 0; 
        if(dp[n] != -1) return dp[n]; 
        return dp[n] = noOfWays(n-1,dp) + noOfWays(n-2,dp); 
    }
}