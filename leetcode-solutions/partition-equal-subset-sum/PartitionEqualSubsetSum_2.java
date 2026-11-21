/*
 * 416. Partition Equal Subset Sum  [Medium]
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * Topics: Array, Dynamic Programming, Knapsack Problem, 0-1 Knapsack
 *
 * Problem:     Can the array be split into two subsets with equal sums?
 * Example:     [1,5,11,5] -> true
 * Constraints: n <= 200, values <= 100
 *
 * Key idea:    If the total is odd, it's impossible. Otherwise it's subset-sum to total/2
 *              (0/1 knapsack): canMake(i, t) = canMake(i-1, t) || canMake(i-1, t -
 *              nums[i]).
 *
 * Approach:    Top-down memo (take / not take)
 * Complexity:  time O(n * sum), space O(n * sum)
 * Also see:    _1: Bottom-up subset-sum with two rows
 * Submitted:   2024-04-05 (submission 1223704992, AC)
 */

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length; 
        int sum =0; 
        for(int i=0; i<n; i++){
            sum += nums[i]; 
        }
        if(sum % 2 !=0 ) return false; 
        int sumToLookFor = sum/2; 
        int[][] dp = new int[n][sumToLookFor+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1); 
        }
        return findSubset(n-1, sumToLookFor, nums,dp); 
    }
    public boolean findSubset(int i, int target, int[] nums, int[][] dp){
        int n = nums.length; 
        if(target ==0) return true; 
        if(i < 0) return false; 
        if(dp[i][target] != -1){
            if(dp[i][target] == 1) return true;
            return false; 
        }
        boolean take = false; 
        if(nums[i] <= target){
            take = findSubset(i-1,target - nums[i], nums,dp); 
        }
        boolean notTake = findSubset(i-1,target, nums,dp);
        boolean result = take || notTake; 
        if(!result) dp[i][target] = 0;
        else dp[i][target] = 1; 
        return result; 
    }
}