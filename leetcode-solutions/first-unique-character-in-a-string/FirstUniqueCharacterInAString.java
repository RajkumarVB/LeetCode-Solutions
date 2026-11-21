/*
 * 387. First Unique Character in a String  [Easy]
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * Topics: Hash Table, String, Queue, Counting
 *
 * Problem:     Return the index of the first character that appears exactly once in s, or
 *              -1.
 * Example:     "leetcode" -> 0; "loveleetcode" -> 2
 * Constraints: n <= 1e5, lowercase
 *
 * Key idea:    Two passes: count frequencies (an int[26] is enough), then return the first
 *              index whose count is 1.
 *
 * Approach:    Frequency map + second pass
 * Complexity:  time O(n), space O(1) (26 letters)
 * Submitted:   2023-12-27 (submission 1129115326, AC)
 */

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>(); 
        
        for(char c : s.toCharArray()){
            int count = countMap.getOrDefault(c,0); 
            countMap.put(c,count+1); 
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i); 
            if(countMap.get(c) == 1) return i; 
        }
        return -1; 
    }
}