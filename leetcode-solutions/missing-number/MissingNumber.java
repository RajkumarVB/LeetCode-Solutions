/*
 * 268. Missing Number  [Easy]
 * https://leetcode.com/problems/missing-number/
 * Topics: Array, Hash Table, Math, Binary Search, Bit Manipulation, Sorting
 *
 * Problem:     An array holds n distinct numbers from [0, n]. Return the one missing
 *              number.
 * Example:     [3,0,1] -> 2
 * Constraints: n <= 1e4
 *
 * Key idea:    XOR all indices 0..n with all values; pairs cancel (x ^ x = 0), leaving the
 *              missing number. Equivalent: n(n+1)/2 - sum.
 *
 * Approach:    XOR of indices and values
 * Complexity:  time O(n), space O(1)
 * Submitted:   2023-12-23 (submission 1126798110, AC)
 */

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length; 
        int result = n ; 
        for(int i=0; i<n ; i++){
            result ^= nums[i] ^ i; 
        }
        return result; 
    }
}