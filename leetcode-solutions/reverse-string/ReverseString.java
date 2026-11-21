/*
 * 344. Reverse String  [Easy]
 * https://leetcode.com/problems/reverse-string/
 * Topics: Two Pointers, String
 *
 * Problem:     Reverse a char array in place.
 * Example:     [h,e,l,l,o] -> [o,l,l,e,h]
 * Constraints: n <= 1e5
 *
 * Key idea:    Swap from both ends moving inward.
 *
 * Approach:    Two-pointer swap
 * Complexity:  time O(n), space O(1)
 * Submitted:   2023-12-27 (submission 1129139674, AC)
 */

class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length -1; 
        while(left < right){
            swap(s,left, right); 
            left ++; 
            right --; 
        }
    }
    public static void swap(char[]s, int left, int right){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp; 
    }
}