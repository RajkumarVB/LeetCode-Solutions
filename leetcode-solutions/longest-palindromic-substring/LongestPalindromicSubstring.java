/*
 * 5. Longest Palindromic Substring  [Medium]
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Topics: Two Pointers, String, Dynamic Programming, Manacher
 *
 * Problem:     Return the longest palindromic substring of s.
 * Example:     "babad" -> "bab" (or "aba")
 * Constraints: n <= 1000
 *
 * Key idea:    Expand around each centre: 2n-1 centres (each character and each gap).
 *              Expand while the ends match and keep the longest.
 *
 * Approach:    Expand around centre (odd and even)
 * Complexity:  time O(n^2), space O(1)
 * Submitted:   2024-04-02 (submission 1220410342, AC)
 */

class Solution {
    int resultStart = -1; 
    int resultEnd = -1; 
    int resultLength =0; 
    public String longestPalindrome(String s) {
        int n = s.length(); 
        for(int i=0; i<n; i++){
            expandRange(s,i,i);
            expandRange(s,i,i+1); 
        }
        return s.substring(resultStart, resultEnd+1); 
    }
    public void expandRange(String s, int left, int right){
        int n = s.length(); 
        if(right >= n) return; 
        while(left >=0 && right <= n-1 && s.charAt(left) == s.charAt(right)){
            left --; 
            right ++; 
        }
        if(right - left + 1 > resultLength){
            resultLength = right - left + 1; 
            resultStart = left + 1; 
            resultEnd = right - 1; 
        }
    }
}