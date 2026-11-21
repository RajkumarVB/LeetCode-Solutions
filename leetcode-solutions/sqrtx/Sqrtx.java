/*
 * 69. Sqrt(x)  [Easy]
 * https://leetcode.com/problems/sqrtx/
 * Topics: Math, Binary Search, Newton's Method
 *
 * Problem:     Return floor(sqrt(x)) without using pow or sqrt.
 * Example:     8 -> 2
 * Constraints: 0 <= x <= 2^31 - 1
 *
 * Key idea:    Binary search for the largest m with m*m <= x. Use long for m*m to avoid
 *              overflow.
 *
 * Approach:    Binary search on the answer
 * Complexity:  time O(log x), space O(1)
 * Submitted:   2023-12-25 (submission 1127987746, AC)
 */

class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x; 
        long left =1 ; 
        long right = x; 
        long ans = -1; 
        while(left <= right){
            long mid = left + (right - left) /2 ; 
            if(mid * mid == x) return (int) mid; 
            if(mid * mid < x){
                ans = mid; 
                left = mid +1; 
            } else {
                right = mid -1; 
            }
        }
        return (int) ans; 
    }
}