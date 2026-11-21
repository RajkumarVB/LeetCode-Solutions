/*
 * 190. Reverse Bits  [Easy]
 * https://leetcode.com/problems/reverse-bits/
 * Topics: Divide and Conquer, Bit Manipulation
 *
 * Problem:     Reverse the bits of a 32-bit integer.
 * Example:     00000010100101000001111010011100 -> 00111001011110000010100101000000
 * Constraints: 32 bits
 *
 * Key idea:    32 times: result = (result << 1) | (n & 1); n >>>= 1. Use the unsigned shift
 *              >>> in Java.
 *
 * Approach:    Shift result left, take n's lowest bit
 * Complexity:  time O(32), space O(1)
 * Submitted:   2023-12-27 (submission 1129518645, AC)
 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0; 
        for(int i =1 ; i<=32; i++){
            result = result << 1; 
            int lastBit = (n & 1); 
            result |= lastBit; 
            n >>=1 ; 
        }
        return result; 
    }
}