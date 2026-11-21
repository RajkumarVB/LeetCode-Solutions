/*
 * 1. Two Sum  [Easy]
 * https://leetcode.com/problems/two-sum/
 * Topics: Array, Hash Table
 *
 * Problem:     Return the indices of the two numbers that add up to target (exactly one
 *              solution).
 * Example:     [2,7,11,15], target=9 -> [0,1]
 * Constraints: n <= 1e4
 *
 * Key idea:    One pass with a HashMap value -> index: for each x, if target - x has been
 *              seen, you're done; otherwise store x.
 *
 * Approach:    Brute force pairs
 * Complexity:  time O(n^2), space O(1)
 * Also see:    _1: One-pass HashMap of complements
 * Submitted:   2023-10-21 (submission 1080369445, AC)
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length; 
        for(int i=0; i<n ;i++){
            for(int j=i+1; j<n; j++){
                if(nums[i] + nums[j] ==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}