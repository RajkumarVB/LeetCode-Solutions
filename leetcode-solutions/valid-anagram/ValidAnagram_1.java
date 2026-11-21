/*
 * 242. Valid Anagram  [Easy]
 * https://leetcode.com/problems/valid-anagram/
 * Topics: Hash Table, String, Sorting
 *
 * Problem:     Return whether t is an anagram of s.
 * Example:     "anagram", "nagaram" -> true
 * Constraints: lengths <= 5e4
 *
 * Key idea:    An int[26] count: increment for s, decrement for t, then check all zeros.
 *              For Unicode, use a HashMap.
 *
 * Approach:    26-letter count array
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: HashMap counts (Unicode friendly)
 * Submitted:   2026-09-02 (submission 2128684803, AC)
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26]; 
        for(char c : s.toCharArray()){
            hash[c-'a']++; 
        }
        for(char c : t.toCharArray()){
            hash[c-'a']--; 
        }
        for(int i=0; i<26; i++){
            if(hash[i] != 0) return false; 
        }
        return true; 
    }
}