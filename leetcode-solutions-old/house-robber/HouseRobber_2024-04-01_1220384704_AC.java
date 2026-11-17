class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        int[] dp = new int[n]; 
        for(int i=n-1; i>=0 ;i--){
            int path1 = nums[i], path2 =0; 
            if(i+2 < n) path1 += dp[i+2]; 
            if(i+1 < n) path2 = dp[i+1]; 
            dp[i] = Math.max(path1,path2); 
        }
        return dp[0];
    }
    public int maxMoney(int i, int n, int[] nums,int[]dp){
        if(i >= n) return 0; 
        if(dp[i] != -1) return dp[i]; 
        int path1 = nums[i] + maxMoney(i+2,n,nums,dp); 
        int path2 = maxMoney(i+1,n,nums,dp); 
        return dp[i] = Math.max(path1,path2); 
    }
}