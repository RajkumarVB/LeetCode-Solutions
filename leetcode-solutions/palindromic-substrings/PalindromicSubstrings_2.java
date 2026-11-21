/*
 * 647. Palindromic Substrings  [Medium]
 * https://leetcode.com/problems/palindromic-substrings/
 * Topics: Two Pointers, String, Dynamic Programming
 *
 * Problem:     Count the palindromic substrings of s (by position).
 * Example:     "aaa" -> 6
 * Constraints: n <= 1000
 *
 * Key idea:    Expand around each of the 2n-1 centres; every successful expansion step is
 *              one more palindrome.
 *
 * Approach:    Brute force check every substring
 * Complexity:  time O(n^3), space O(n)
 * Also see:    _1: Expand around centres
 * Submitted:   2024-04-04 (submission 1222808331, AC)
 */

class Solution {
    public int countSubstrings(String s) {
        int n = s.length(); 
        int result =0; 
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalindrome(s.substring(i,j+1))){
                    result ++; 
                }
            }
        }
        return result; 
    }
    public boolean isPalindrome(String s){
        int n = s.length();
        int left = 0, right = n-1; 
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false; 
            }
            left ++; 
            right --; 
        }
        return true; 
    }
}