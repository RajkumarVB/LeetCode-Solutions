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
 * Approach:    HashMap counts (Unicode friendly)
 * Complexity:  time O(n), space O(k)
 * Also see:    _1: 26-letter count array
 * Submitted:   2023-12-19 (submission 1123617158, AC)
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>(); 

        int n = s.length(); 
        int m = t.length(); 
        for(int i=0; i<n; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1) ; 
        }

        for(int i=0; i<m; i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)-1);
        }

        for(int count : map.values()){
            if(count != 0) return false; 
        }

        return true; 
    }
}