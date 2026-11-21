/*
 * 28. Find the Index of the First Occurrence in a String  [Easy]
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * Topics: Two Pointers, String, String Matching, Z Algorithm, Knuth–Morris–Pratt Algorithm,
 *         Boyer–Moore String-Search Algorithm
 *
 * Problem:     Return the index of the first occurrence of needle in haystack, or -1.
 * Example:     haystack="sadbutsad", needle="sad" -> 0
 * Constraints: lengths <= 1e4
 *
 * Key idea:    Brute force compares needle at each start: O(n*m). KMP builds a prefix (LPS)
 *              table to get O(n+m). In an interview, know at least the brute force and the
 *              idea of KMP.
 *
 * Approach:    Brute force compare at each start
 * Complexity:  time O(n*m), space O(m)
 * Also see:    _2: Built-in indexOf
 * Submitted:   2023-12-23 (submission 1126365380, AC)
 */

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if(m > n ) return -1; 

        int firstChar = needle.charAt(0); 
        for(int i=0; i<n ; i++){
            char c = haystack.charAt(i); 
            if(firstChar == c){
                if(isPresent(haystack,needle,i)) return i; 
            }
        }
        return -1; 
    }
    public static boolean isPresent(String s1, String s2, int i){
        int n = s1.length();
        int m = s2.length();
        
        if(i+m > n) return false; 
        return s1.substring(i,i+m).equals(s2); 
    }
}