class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length; 
        long sum =0; 
        for(int i=0; i<n; i++){
            sum += nums[i]; 
        }
        if(sum % 2 !=0 ) return false; 
        int[] dp = new int[n];
        Arrays.fill(dp,-1); 
        long sumToLookFor = sum/2; 
        return findSubset(n-1, sumToLookFor, nums,dp); 
    }
    public boolean findSubset(int i, long target, int[] nums, int[] dp){
        int n = nums.length; 
        if(target ==0) return true; 
        if(i < 0) return false; 
        if(dp[i] != -1){
            if(dp[i] == 1) return true;
            return false; 
        }
        boolean take = false; 
        if(nums[i] <= target){
            take = findSubset(i-1,target - nums[i], nums,dp); 
        }
        boolean notTake = findSubset(i-1,target, nums,dp);
        boolean result = take || notTake; 
        if(!result) dp[i] = 0;
        else dp[i] = 1; 
        return result; 
    }
}