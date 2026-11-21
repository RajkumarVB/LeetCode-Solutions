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
 * Approach:    Digit pop/push with pre-overflow check
 * Complexity:  time O(log x), space O(1)
 * Also see:    _2: Use long and check the range (breaks the no-64-bit rule)
 * Submitted:   2023-12-30 (submission 1132112207, AC)
 */

class Solution {
    public int reverse(int x) {
        int result =0; 
        while(x !=0){
            int digit = x%10; 

            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10) && (digit >Integer.MAX_VALUE%10)) return 0; 

            if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10) && (digit <Integer.MIN_VALUE%10)) return 0; 

            result = (result*10) + digit; 
            x /= 10; 
        }
        return result;
    }
}