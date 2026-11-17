class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; 
        int[] dp = new int[n]; 
        Arrays.fill(dp,-1); 
        return lLIS(0,0,nums,1,dp); 
    }
    public int lLIS(int i, int last, int[] nums, int length,int[] dp){
        int n = nums.length; 
        if(i >= n) return length; 
        if(dp[i] != -1) return dp[i]; 
        int take = 0; 
        if(i != 0 && nums[i] > last){
            take = lLIS(i+1,nums[i],nums,length+1,dp); 
        }
        int notTake = lLIS(i+1,nums[i],nums,length,dp); 
        return dp[i] = Math.max(take,notTake); 
    }
}