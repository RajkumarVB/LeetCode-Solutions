class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        int[] dp = new int[n]; 
        // Arrays.fill(dp, -1);
        // return findMaxAmount(nums, n - 1, dp); 
        return findMaxAmount(nums,dp);
    }

    public int findMaxAmount(int[] nums, int[] dp){
        int n = nums.length; 
        dp[0] = nums[0];
        for(int i=1; i<n; i++){
            int take = nums[i]; 
            if(i > 1){
                take += dp[i-2];
            }
            // not take the last element
            int notTake = dp[i-1]; 
            dp[i] = Math.max(take, notTake);
        }
        return dp[n-1];
    }

    public int backtrack(int[] nums, int i, int[] dp){
        if(i < 0){
            // no elements to pick
            return 0; 
        }
        if(i ==0){
            // reached here means, index 1 element is not picked up
            return nums[0]; 
        }
        if(dp[i] != -1) return dp[i];

        // take the last element 
        int take = nums[i] + backtrack(nums, i-2, dp); 
        // not take the last element
        int notTake = backtrack(nums, i-1, dp); 
        return dp[i] = Math.max(take, notTake); 
    }
}