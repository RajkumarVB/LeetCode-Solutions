/*
 * 198. House Robber  [Medium]
 * https://leetcode.com/problems/house-robber/
 * Topics: Array, Dynamic Programming
 *
 * Problem:     Houses in a row hold money; you can't rob two adjacent houses. Return the
 *              maximum you can rob.
 * Example:     [2,7,9,3,1] -> 12 (2 + 9 + 1)
 * Constraints: n <= 100
 *
 * Key idea:    dp[i] = max(nums[i] + dp[i-2] (rob it), dp[i-1] (skip it)). Only the last
 *              two values are needed.
 *
 * Approach:    Bottom-up with two variables
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: Top-down memo (take / not take); _3: Bottom-up dp array from the right
 * Submitted:   2026-01-01 (submission 1871229136, AC)
 */

class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        int[] dp = new int[n]; 
        // Arrays.fill(dp, -1);
        // return findMaxAmount(nums, n - 1, dp); 
        return findMaxAmount(nums);
    }

    public int findMaxAmount(int[] nums){
        int n = nums.length; 
        int prev = nums[0];
        int curr = 0; 
        int prev2 = 0; 
        for(int i=1; i<n; i++){
            int take = nums[i]; 
            if(i > 1){
                take += prev2;
            }
            // not take the last element
            int notTake = prev; 
            curr = Math.max(take, notTake);

            prev2 = prev; 
            prev = curr; 
        }
        return prev;
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