/*
 * 326. Power of Three  [Easy]
 * https://leetcode.com/problems/power-of-three/
 * Topics: Math, Recursion
 *
 * Problem:     Return whether n is a power of three.
 * Example:     27 -> true; 45 -> false
 * Constraints: 32-bit int
 *
 * Key idea:    Divide by 3 while divisible and check whether you reach 1. No-loop trick:
 *              3^19 (1162261467) is the largest power of 3 in an int, so n > 0 &&
 *              1162261467 % n == 0.
 *
 * Approach:    Repeated division
 * Complexity:  time O(log n), space O(1)
 * Submitted:   2023-12-27 (submission 1129143187, AC)
 */

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false; 
        while(n >1){
            if(n % 3 != 0) return false ; 
            n /= 3; 
        }
        return true; 
    }
}