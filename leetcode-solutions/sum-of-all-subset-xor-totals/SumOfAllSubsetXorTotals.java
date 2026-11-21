/*
 * 1863. Sum of All Subset XOR Totals  [Easy]
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 * Topics: Array, Math, Backtracking, Bit Manipulation, Combinatorics, Enumeration
 *
 * Problem:     Return the sum of the XOR of every subset.
 * Example:     [1,3] -> 6 (0 + 1 + 3 + 2)
 * Constraints: n <= 12
 *
 * Key idea:    Enumerate all 2^n masks and XOR the chosen elements. Neat O(n) trick: answer
 *              = (OR of all elements) << (n - 1).
 *
 * Approach:    Bitmask enumeration
 * Complexity:  time O(n * 2^n), space O(1)
 * Submitted:   2025-04-05 (submission 1597643455, AC)
 */

class Solution {
    public int subsetXORSum(int[] nums) {
        int result =0; 
        int n = nums.length; 
        for(int i=0; i< (1<<n); i++){
            int subsetXor = 0; 
            for(int j=0; j<n; j++){
                if((i & (1 << j)) != 0){
                    subsetXor ^= nums[j]; 
                }
            }
            result += subsetXor; 
        }
        return result; 
    }
}