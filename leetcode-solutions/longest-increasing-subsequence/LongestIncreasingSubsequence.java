/*
 * 300. Longest Increasing Subsequence  [Medium]
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * Topics: Array, Binary Search, Dynamic Programming, Longest Increasing Subsequence
 *
 * Problem:     Return the length of the longest strictly increasing subsequence.
 * Example:     [10,9,2,5,3,7,101,18] -> 4
 * Constraints: n <= 2500
 *
 * Key idea:    DP over (index, previous index): take nums[i] if it's larger than the
 *              previous, or skip it. O(n log n) alternative: keep a 'tails' array and
 *              binary-search where each number goes.
 *
 * Approach:    Top-down memo on (i, prevIdx)
 * Complexity:  time O(n^2), space O(n^2)
 * Submitted:   2024-04-03 (submission 1221913905, AC)
 */

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
