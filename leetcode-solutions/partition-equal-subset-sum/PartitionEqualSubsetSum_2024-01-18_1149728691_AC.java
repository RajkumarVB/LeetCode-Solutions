class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        int n = nums.length; 
        for(int i=0; i<n; i++) sum += nums[i]; 
        if(sum %2 !=0) return false; // If sum is odd you cannot split it to two subsets of equal sum. 

        int sumToLookFor = sum/2 ; 
        int[][] dp = new int[n][sumToLookFor+1];
        for(int [] arr: dp) Arrays.fill(arr,-1); 
        return isSumPresent(n-1,sumToLookFor,nums,dp); 
    }
    public boolean isSumPresent(int index, int target, int[] nums,int[][] dp){
        if(target == 0) return true; 
        if(index ==0){
            if(nums[0] == target) return true; 
            return false; 
        }

        if(dp[index][target] != -1){
            if(dp[index][target]==1) return true; 
            return false; 
        }

        boolean notTake = isSumPresent(index-1, target, nums,dp); 
        boolean take = false; 
        if(target >= nums[index]){
            take = isSumPresent(index-1, target - nums[index], nums,dp); 
        }
        boolean result = take || notTake; 
        dp[index][target] = (result) ? 1 : 0; 
        return result; 
    }
}