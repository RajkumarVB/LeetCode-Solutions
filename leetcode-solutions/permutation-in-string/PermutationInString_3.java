/*
 * 567. Permutation in String  [Medium]
 * https://leetcode.com/problems/permutation-in-string/
 * Topics: Hash Table, Two Pointers, String, Sliding Window
 *
 * Problem:     Does s2 contain some permutation of s1 as a substring?
 * Example:     s1="ab", s2="eidbaooo" -> true
 * Constraints: lengths <= 1e4
 *
 * Key idea:    Fixed-size sliding window of length |s1| with 26-letter counts. Track
 *              'matches' (how many of the 26 counts are equal) so each slide is O(1); found
 *              when matches == 26.
 *
 * Approach:    Brute force: check every substring
 * Complexity:  time O(n * m), space O(1)
 * Also see:    _1: Fixed window + matches counter; _2: Fixed window, compare 26 counts each
 *              slide
 * Submitted:   2024-01-23 (submission 1154429661, AC)
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length(); 
        if(m < n) return false; 
        int i =0; 
        int j = n-1; 
        while(j < m){
            if(isValid(s1,s2.substring(i,j+1))) return true;
            j++;
            i++;
        }
        return false;
    }
    public boolean isValid(String s1, String s2){
        if(s1.length() != s2.length()) return false; 
        int[] charCount = new int[26];
        for(int i=0; i<s1.length(); i++){
            charCount[s1.charAt(i) - 'a'] ++; 
            charCount[s2.charAt(i) - 'a'] --; 
        }
        for(int i=0; i<26; i++){
            if(charCount[i] !=0) return false;
        }
        return true; 
    }
}