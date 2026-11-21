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
 * Approach:    Prefix into output + running suffix
 * Complexity:  time O(n), space O(1) extra
 * Also see:    _2: Separate prefix and suffix arrays
 * Submitted:   2024-01-06 (submission 1138477141, AC)
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 
        int[] ans = new int[n];
        ans[0] =1; 

        for(int i=1; i<n; i++){
           ans[i] = ans[i-1] * nums[i-1]; 
        }

        int suffixProduct = 1; 

        for(int i=n-1; i>=0; i--){
            ans[i] = ans[i] * suffixProduct; 
            suffixProduct *= nums[i]; 
        }
        
        return ans;
    }
}