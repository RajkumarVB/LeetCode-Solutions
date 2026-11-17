class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length; 
        int[] dp = new int[n+1]; 
        Arrays.fill(dp,-1); 
        return findMinCost(n, cost, dp);
    }
    public int findMinCost(int n, int[] cost, int[] dp){
        if(n < 0) return Integer.MAX_VALUE; 
        if(n ==0 || n==1 ) return dp[n] = 0; 
        if(dp[n] != -1) return dp[n]; 
        return dp[n] = Math.min(findMinCost(n-1,cost,dp) + cost[n-1], findMinCost(n-2,cost,dp) + cost[n-2]); 
    }
}