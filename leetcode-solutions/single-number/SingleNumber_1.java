/*
 * 136. Single Number  [Easy]
 * https://leetcode.com/problems/single-number/
 * Topics: Array, Bit Manipulation
 *
 * Problem:     Every element appears twice except one. Find it in O(n) time and O(1) space.
 * Example:     [4,1,2,1,2] -> 4
 * Constraints: n <= 3e4
 *
 * Key idea:    XOR everything: x ^ x = 0 and x ^ 0 = x, so pairs cancel and the single
 *              value remains.
 *
 * Approach:    XOR of all elements
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: HashMap counting
 * Submitted:   2023-12-24 (submission 1127582368, AC)
 */

class Solution {
    public int singleNumber(int[] nums) {
        int result =0 ; 
        for(int element : nums){
            result ^= element; 
        }
        return result;
    }
}