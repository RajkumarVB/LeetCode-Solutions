/*
 * 53. Maximum Subarray  [Medium]
 * https://leetcode.com/problems/maximum-subarray/
 * Topics: Array, Divide and Conquer, Dynamic Programming
 *
 * Problem:     Return the largest sum of any contiguous subarray.
 * Example:     [-2,1,-3,4,-1,2,1,-5,4] -> 6
 * Constraints: n <= 1e5
 *
 * Key idea:    Kadane's algorithm: keep a running sum, record the max, and reset the sum to
 *              0 when it goes negative (a negative prefix only hurts).
 *
 * Approach:    Kadane's algorithm
 * Complexity:  time O(n), space O(1)
 * Submitted:   2024-02-25 (submission 1185847067, AC)
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length; 
        int sum = 0; 
        int maxSum = Integer.MIN_VALUE; 
        for(int num : nums){
            sum += num; 
            maxSum = Math.max(maxSum, sum); 
            if(sum < 0) sum =0; 
        }
        return maxSum; 
    }
}