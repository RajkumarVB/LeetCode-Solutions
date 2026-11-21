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
 * Approach:    HashMap keyed by sorted string
 * Complexity:  time O(n * k log k), space O(n*k)
 * Also see:    _2: HashMap keyed by letter-count array; _3: Brute force pairwise anagram
 *              check
 * Submitted:   2025-09-10 (submission 1766206518, AC)
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String s : strs){
            char[] keyChars = s.toCharArray();
            Arrays.sort(keyChars);
            String key = String.valueOf(keyChars);
            if(!groups.containsKey(key)){
                groups.put(key, new LinkedList<>());
            }
            groups.get(key).add(s);
        }
        return new LinkedList<>(groups.values());
    }
}

// ["nat","tan"]

// ant -> nat tan 


// ["ate","eat","tea"]

// aet -> ate, eat, tea