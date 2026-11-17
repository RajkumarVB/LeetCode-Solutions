class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; 
        int[][] dp = new int[n][n+1]; 
        for(int[] arr : dp){
            Arrays.fill(arr,-1); 
        }
        return lLIS(0,-1,nums,n,dp);
    }
    public int lLIS(int i, int prev_idx, int[] nums, int n, int[][] dp){
        if(i >= n) return 0; 
        if(dp[i][prev_idx + 1] != -1) return dp[i][prev_idx + 1]; 
        int notTake = 0 + lLIS(i+1,prev_idx, nums, n,dp); 
        int take = 0; 
        if(prev_idx == -1 || nums[i] > nums[prev_idx]){
            take =  1 + lLIS(i+1,i,nums,n,dp); 
        }
        return dp[i][prev_idx + 1] = Math.max(notTake, take); 
    }
}
