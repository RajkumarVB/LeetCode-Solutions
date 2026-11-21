/*
 * 191. Number of 1 Bits  [Easy]
 * https://leetcode.com/problems/number-of-1-bits/
 * Topics: Divide and Conquer, Bit Manipulation
 *
 * Problem:     Count the set bits in an integer's binary representation.
 * Example:     11 (1011) -> 3
 * Constraints: n <= 2^31 - 1
 *
 * Key idea:    Check each of the 32 bits with a mask. Faster trick: n &= (n - 1) clears the
 *              lowest set bit, so loop until n == 0.
 *
 * Approach:    Check 32 bits with a mask
 * Complexity:  time O(32), space O(1)
 * Submitted:   2023-12-27 (submission 1129520825, AC)
 */

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0; 
        for(int i=1; i<=32; i++){
            int lastBit = (n & (1 <<31)); 
            if(lastBit !=0) count ++; 
            n <<=1; 
        }
        return count; 
    }
}