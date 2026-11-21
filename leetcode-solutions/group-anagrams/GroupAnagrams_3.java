/*
 * 49. Group Anagrams  [Medium]
 * https://leetcode.com/problems/group-anagrams/
 * Topics: Array, Hash Table, String, Sorting
 *
 * Problem:     Group the strings that are anagrams of each other.
 * Example:     [eat,tea,tan,ate,nat,bat] -> [[eat,tea,ate],[tan,nat],[bat]]
 * Constraints: <= 1e4 strings, length <= 100
 *
 * Key idea:    Anagrams share a canonical key: the sorted string, or the 26-letter count
 *              array. Map key -> list of strings.
 *
 * Approach:    Brute force pairwise anagram check
 * Complexity:  time O(n^2 * k), space O(n)
 * Also see:    _1: HashMap keyed by sorted string; _2: HashMap keyed by letter-count array
 * Submitted:   2025-03-01 (submission 1558474216, AC)
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new LinkedList<>(); 
        int n = strs.length;
        boolean[] isTaken = new boolean[n]; 
        for(int i =0; i<n; i++){
            if(isTaken[i]) continue; 
            isTaken[i] = true; 
            String s1 = strs[i]; 
            List<String> temp = new LinkedList<>(); 
            temp.add(s1); 
            for(int j= i+1; j<n; j++){
                if(isTaken[j]) continue; 
                String s2 = strs[j]; 
                if(isAnagram(s1,s2)){
                    temp.add(s2); 
                    isTaken[j] = true; 
                }
            }
            ans.add(temp);
        }
        return ans; 
    }

    public static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false; 
        int[] charCount = new int[26]; 
        for(int i=0; i<s1.length(); i++){
            char c1 = s1.charAt(i); 
            char c2 = s2.charAt(i); 
            charCount[c1-'a']++; 
            charCount[c2-'a']--; 
        }
        for(int count : charCount){
            if(count != 0) return false; 
        }
        return true; 
    }
}

// Input: strs = ["eat","tea","tan","ate","nat","bat"]

// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

