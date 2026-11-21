/*
 * 8. String to Integer (atoi)  [Medium]
 * https://leetcode.com/problems/string-to-integer-atoi/
 * Topics: String
 *
 * Problem:     Parse a string to a 32-bit int: skip leading spaces, read an optional sign,
 *              read digits until a non-digit, and clamp to the int range.
 * Example:     "   -042" -> -42; "4193 with words" -> 4193
 * Constraints: length <= 200
 *
 * Key idea:    A careful state walk. Before each result*10 + digit, check against MAX/10
 *              and MIN/10 to clamp without overflowing.
 *
 * Approach:    Linear parse with pre-overflow checks
 * Complexity:  time O(n), space O(1)
 * Submitted:   2023-12-30 (submission 1132237451, AC)
 */

class Solution {
    public int myAtoi(String s) {
        
        int n = s.length(); 

        int i =0; 
        boolean isPositive = true; 
        int result = 0; 

        while(i < n && s.charAt(i) ==' ') i++; 
        
        if((i < n) && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            if(s.charAt(i) == '-'){
                isPositive = false; 
            }
            i++; 
        }

        while(i < n && isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0'; 
            digit = (!isPositive) ? -digit : digit ;

            if((result > Integer.MAX_VALUE/10) || (result == Integer.MAX_VALUE/10) && (digit > Integer.MAX_VALUE % 10)) return Integer.MAX_VALUE; 
            if((result < Integer.MIN_VALUE/10) || (result == Integer.MIN_VALUE/10) && (digit < Integer.MIN_VALUE % 10)) return Integer.MIN_VALUE; 

            result *= 10; 
            result += digit; 
            i++;
        }

        return result ;
    }

    public boolean isDigit(char c){
        return (c >= '0' && c<='9') ;
    }
}