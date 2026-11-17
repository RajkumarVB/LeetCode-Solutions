class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        int n = nums.length; 
        for(int i=0; i<n; i++) sum += nums[i]; 
        if(sum %2 !=0) return false; // If sum is odd you cannot split it to two subsets of equal sum. 

        int sumToLookFor = sum/2 ; 
        boolean[][] dp = new boolean[n][sumToLookFor+1];

        for(int index = 0; index <n ; index++){
            dp[index][0] = true; 
        }

        if(nums[0] <= sumToLookFor){
            dp[0][nums[0]] = true; 
        }

        for(int index =1; index <n ; index++){
            for(int target = 1; target <= sumToLookFor; target++){
                boolean notTake = dp[index-1][target]; 
                boolean take = false; 
                if(target >= nums[index]){
                    take = dp[index-1][target - nums[index]]; 
                }
                dp[index][target] = take || notTake; 
            }
        }
        return dp[n-1][sumToLookFor]; 
    }
}