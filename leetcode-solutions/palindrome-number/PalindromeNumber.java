/*
 * 9. Palindrome Number  [Easy]
 * https://leetcode.com/problems/palindrome-number/
 * Topics: Math
 *
 * Problem:     Return whether an integer reads the same backwards (negatives are never
 *              palindromes).
 * Example:     121 -> true; -121 -> false
 * Constraints: 32-bit int
 *
 * Key idea:    Reverse the digits arithmetically (rev = rev*10 + x%10) and compare.
 *              Reversing only half the digits avoids any overflow risk.
 *
 * Approach:    Reverse digits and compare
 * Complexity:  time O(log x), space O(1)
 * Submitted:   2023-02-27 (submission 905820146, AC)
 */

class Solution {
    public boolean isPalindrome(int x) {
        if(x <0) return false ; 
        int temp = x ; 
        int reverseNumber = 0 ;  
        while(temp >0){
            reverseNumber = (temp % 10) + (reverseNumber *10) ;
            temp /=10 ; 
        }
        if(reverseNumber == x) return true ; 
        return false ;
    }
}