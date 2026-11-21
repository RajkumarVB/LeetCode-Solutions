/*
 * 2149. Rearrange Array Elements by Sign  [Medium]
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 * Topics: Array, Two Pointers, Simulation
 *
 * Problem:     An array has equally many positives and negatives. Rearrange it to alternate
 *              positive, negative, ..., starting with a positive, keeping relative order
 *              within each sign.
 * Example:     [3,1,-2,-5,2,-4] -> [3,-2,1,-5,2,-4]
 * Constraints: n <= 2e5
 *
 * Key idea:    Two write pointers into a new array: positives go to even indices (0, 2,
 *              ...), negatives to odd (1, 3, ...).
 *
 * Approach:    Even/odd write pointers
 * Complexity:  time O(n), space O(n)
 * Also see:    _2: Split into two lists, then interleave
 * Submitted:   2025-01-08 (submission 1502132749, AC)
 */

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length; 
        int ans[] = new int[n];
        int nextPostivePointer =0, nextNegativePointer = 1; 
        for(int element : nums){
            if(element > 0){
                ans[nextPostivePointer] = element; 
                nextPostivePointer +=2; 
            }else{
                ans[nextNegativePointer] = element; 
                nextNegativePointer +=2; 
            }
        }
        return ans; 
    }
}