class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        int[] dp = new int[n]; 
        Arrays.fill(dp,-1); 
        return maxMoney(0,n,nums,dp);
    }
    public int maxMoney(int i, int n, int[] nums,int[]dp){
        if(i >= n) return 0; 
        if(dp[i] != -1) return dp[i]; 
        int path1 = nums[i] + maxMoney(i+2,n,nums,dp); 
        int path2 = maxMoney(i+1,n,nums,dp); 
        return dp[i] = Math.max(path1,path2); 
    }
}