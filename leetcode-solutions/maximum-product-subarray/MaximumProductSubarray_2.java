/*
 * 152. Maximum Product Subarray  [Medium]
 * https://leetcode.com/problems/maximum-product-subarray/
 * Topics: Array, Dynamic Programming
 *
 * Problem:     Return the largest product of any contiguous subarray.
 * Example:     [2,3,-2,4] -> 6
 * Constraints: n <= 2e4
 *
 * Key idea:    A negative number flips max and min, so track both the max and min product
 *              ending here. Equivalent trick: the best subarray is a prefix or a suffix
 *              between zeros, so scan prefix and suffix products, resetting to 1 after a
 *              zero.
 *
 * Approach:    Brute force all subarrays
 * Complexity:  time O(n^2), space O(1)
 * Also see:    _1: Prefix and suffix products, reset at 0
 * Submitted:   2024-01-06 (submission 1137870495, AC)
 */

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length; 
        int result = Integer.MIN_VALUE; 
        for(int i=0; i<n; i++){
            int product = 1; 
            for(int j=i; j<n; j++){
                product *= nums[j]; 
                result = Math.max(result, product); 
            }
        }
        return result; 
    }
}