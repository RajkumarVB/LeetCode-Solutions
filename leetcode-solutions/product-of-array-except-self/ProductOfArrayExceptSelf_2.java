/*
 * 238. Product of Array Except Self  [Medium]
 * https://leetcode.com/problems/product-of-array-except-self/
 * Topics: Array, Prefix Sum
 *
 * Problem:     Return an array where each position holds the product of all other elements,
 *              in O(n) without division.
 * Example:     [1,2,3,4] -> [24,12,8,6]
 * Constraints: n <= 1e5
 *
 * Key idea:    answer[i] = (product of everything left of i) * (product of everything right
 *              of i). Fill prefix products into the output, then multiply in a running
 *              suffix product from the right: O(1) extra space.
 *
 * Approach:    Separate prefix and suffix arrays
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: Prefix into output + running suffix
 * Submitted:   2024-01-06 (submission 1138421864, AC)
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 

        int[] prefixProduct = new int[n]; 
        int[] suffixProduct = new int[n]; 

        int prefixProd = 1; 
        int suffixProd = 1; 

        for(int i=0; i<n ;i++){
            prefixProduct[i] = prefixProd;
            suffixProduct[n-1-i] = suffixProd;

            prefixProd *= nums[i];
            suffixProd *= nums[n-1-i];
        }

        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = prefixProduct[i] * suffixProduct[i]; 
        }


        // System.out.println(Arrays.toString(prefixProduct));
        // System.out.println(Arrays.toString(suffixProduct));
        return result; 
    }
}