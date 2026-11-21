/*
 * 125. Valid Palindrome  [Easy]
 * https://leetcode.com/problems/valid-palindrome/
 * Topics: Two Pointers, String
 *
 * Problem:     After lowercasing and dropping non-alphanumeric characters, does the string
 *              read the same both ways?
 * Example:     "A man, a plan, a canal: Panama" -> true
 * Constraints: n <= 2e5
 *
 * Key idea:    Two pointers from both ends, skipping non-alphanumerics and comparing
 *              lowercase characters. No need to build a cleaned copy.
 *
 * Approach:    Two pointers with Character helpers
 * Complexity:  time O(n), space O(1)
 * Submitted:   2023-08-15 (submission 1022312385, AC)
 */

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0 , right = s.length()-1; 
        while(left < right){
            char cLeft, cRight; 
            cLeft = s.charAt(left);
            cRight = s.charAt(right);
            if(!Character.isLetterOrDigit(cLeft)){
                left ++;  
            } else if(!Character.isLetterOrDigit(cRight)){
                right --;  
            } else {
                if(Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) return false ;
                left ++; 
                right --; 
            }
        }
        return true; 
    }
}