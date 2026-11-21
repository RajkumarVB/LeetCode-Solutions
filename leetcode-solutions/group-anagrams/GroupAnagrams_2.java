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
 * Approach:    HashMap keyed by letter-count array
 * Complexity:  time O(n * k), space O(n*k)
 * Also see:    _1: HashMap keyed by sorted string; _3: Brute force pairwise anagram check
 * Submitted:   2025-09-10 (submission 1766213386, AC)
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String s : strs){
            String key = Arrays.toString(computeFrequency(s));
            // System.out.println(key);

            if(!groups.containsKey(key)){
                groups.put(key, new LinkedList<>());
            }
            groups.get(key).add(s);
        }
        return new LinkedList<>(groups.values());
    }
    private int[] computeFrequency(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++; 
        }
        return freq; 
    }
}