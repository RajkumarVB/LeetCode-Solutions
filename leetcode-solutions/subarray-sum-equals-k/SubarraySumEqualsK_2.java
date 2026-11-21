/*
 * 560. Subarray Sum Equals K  [Medium]
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * Topics: Array, Hash Table, Prefix Sum
 *
 * Problem:     Count the contiguous subarrays whose sum equals k (values can be negative).
 * Example:     [1,1,1], k=2 -> 2
 * Constraints: n <= 2e4
 *
 * Key idea:    Prefix sums: subarray (i, j] sums to k if prefix[j] - prefix[i] = k. Keep a
 *              map of prefix-sum counts (seeded with {0: 1}) and add map[sum - k] at each
 *              step. A sliding window fails because of negative numbers.
 *
 * Approach:    Brute force all subarrays
 * Complexity:  time O(n^2), space O(1)
 * Also see:    _1: Prefix sum + HashMap of counts
 * Submitted:   2023-08-28 (submission 1034224915, AC)
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int result = 0 ; 
        for(int i =0 ; i<n; i++){
            int sum = 0 ; 
            for(int j =i ;j<n; j++){
                sum += nums[j];
                if(sum ==k) result ++; 
            }
        }
        return result;
    }
}