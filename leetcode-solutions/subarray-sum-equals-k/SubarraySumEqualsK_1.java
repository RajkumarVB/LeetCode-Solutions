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
 * Approach:    Prefix sum + HashMap of counts
 * Complexity:  time O(n), space O(n)
 * Also see:    _2: Brute force all subarrays
 * Submitted:   2023-09-06 (submission 1042138512, AC)
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        int n = nums.length; 
        int sum = 0, result = 0; 
        prefixSum.put(0,1);
        for(int i=0; i<n;i++){
            sum += nums[i];
            result += prefixSum.getOrDefault(sum-k,0);
            prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);
        }
        return result;
    }
}