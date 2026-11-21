/*
 * 260. Single Number III  [Medium]
 * https://leetcode.com/problems/single-number-iii/
 * Topics: Array, Bit Manipulation
 *
 * Problem:     Exactly two elements appear once and all others twice. Find the two, in O(n)
 *              time and O(1) space.
 * Example:     [1,2,1,3,2,5] -> [3,5]
 * Constraints: n <= 3e4
 *
 * Key idea:    XOR all gives a ^ b (non-zero). Isolate any set bit (x & -x); it separates a
 *              from b. XOR each group separately to get each number.
 *
 * Approach:    XOR all + split by lowest set bit
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: HashMap counting
 * Submitted:   2024-03-10 (submission 1199705860, AC)
 */

class Solution {
    public int[] singleNumber(int[] nums) {
        long xorAll = 0; 
        for(int ele : nums){
            xorAll ^= ele; 
        }
        long rightMost = (xorAll & (xorAll -1)) ^ xorAll; 
        long bucket1 =0, bucket2 =0; 
        for(int ele : nums){
            if((ele & rightMost) ==0){
                bucket1 ^= ele; 
            } else{
                bucket2 ^= ele; 
            }
        }
        return new int[]{(int)bucket1, (int)bucket2}; 
    }
}