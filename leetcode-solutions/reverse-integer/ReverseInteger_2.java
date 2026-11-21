/*
 * 7. Reverse Integer  [Medium]
 * https://leetcode.com/problems/reverse-integer/
 * Topics: Math
 *
 * Problem:     Reverse the digits of a 32-bit signed integer; return 0 if the result
 *              overflows (64-bit integers aren't allowed).
 * Example:     -123 -> -321; 1534236469 -> 0
 * Constraints: 32-bit int
 *
 * Key idea:    Pop digits with % 10 and push with result*10 + digit. Before pushing, check
 *              result against MAX/10 and MIN/10 to detect overflow without using long.
 *
 * Approach:    Use long and check the range (breaks the no-64-bit rule)
 * Complexity:  time O(log x), space O(1)
 * Also see:    _1: Digit pop/push with pre-overflow check
 * Submitted:   2023-02-27 (submission 905829116, AC)
 */

class Solution {
    public int reverse(int x) {
        long reverseNumber =0 ; 
        int temp = x; 
        while(temp != 0){
            reverseNumber = (temp%10) + (reverseNumber * 10) ;
            temp /=10 ;
        }
        if(reverseNumber > Integer.MAX_VALUE || reverseNumber < Integer.MIN_VALUE)
            return 0 ;
        return (int) (reverseNumber) ; 
    }
}