class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        int[] dp = new int[n]; 
        Arrays.fill(dp,-1);
        return solve(nums,0,n,dp);
    }
    public int solve(int[] nums,int i, int n, int[] dp){
        if(i > n-1) return 0; 
        if(dp[i] != -1) return dp[i];
        int path1 =0; 
        int path2 =0; 
        if(i == 0){
            path1 = nums[i] + solve(nums,i+2,n,dp); 
        } else {
            path1 = nums[i] + solve(nums,i+2,n,dp); 
        }
        path2 = solve(nums,i+1,n,dp);
        return dp[i] = Math.max(path1, path2); 
    }
}