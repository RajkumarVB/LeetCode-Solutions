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
 * Approach:    Built-in indexOf
 * Complexity:  time O(n*m), space O(1)
 * Also see:    _1: Brute force compare at each start
 * Submitted:   2023-12-23 (submission 1126368144, AC)
 */

class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle); 
    }
}