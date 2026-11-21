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
 * Approach:    Expand around centres
 * Complexity:  time O(n^2), space O(1)
 * Also see:    _2: Brute force check every substring
 * Submitted:   2024-04-04 (submission 1222826559, AC)
 */

class Solution {
    int palindromeCount = 0; 
    public int countSubstrings(String s) {
        int n = s.length(); 
        for(int i=0; i<n; i++){
            expandRange(i,i+1,s); // even length palindrome 
            expandRange(i,i,s); // odd length palindrome 
        }
        return palindromeCount; 
    }

    public void expandRange(int mid1, int mid2, String s){
        int n = s.length();
        if(mid2 >= n) return; 
        int palindromeLen = 0; 
        while(mid1 >= 0 && mid2 < n){
            if(s.charAt(mid1) != s.charAt(mid2)){
                break;
            }
            palindromeCount ++; 
            mid1 --; 
            mid2 ++; 
        }
    }
}