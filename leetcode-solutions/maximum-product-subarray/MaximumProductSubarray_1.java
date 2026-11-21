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
 * Approach:    Prefix and suffix products, reset at 0
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: Brute force all subarrays
 * Submitted:   2024-04-02 (submission 1221038970, AC)
 */

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length; 
        int result = Integer.MIN_VALUE; 
        int suffix = 1; 
        int prefix = 1; 
        for(int i=0; i<n; i++){
            prefix *= nums[i]; 
            suffix *= nums[n-i-1];

            result = Math.max(result,Math.max(prefix, suffix)); 
            prefix = (prefix ==0) ? 1 : prefix; 
            suffix = (suffix ==0) ? 1 : suffix; 
        }
        return result; 
    }
}