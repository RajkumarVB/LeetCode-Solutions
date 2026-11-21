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
 * Approach:    Bottom-up dp array from the right
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: Bottom-up with two variables; _2: Top-down memo (take / not take)
 * Submitted:   2024-04-01 (submission 1220384704, AC)
 */

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