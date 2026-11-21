/*
 * 3. Longest Substring Without Repeating Characters  [Medium]
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Topics: Hash Table, String, Sliding Window
 *
 * Problem:     Return the length of the longest substring with all distinct characters.
 * Example:     "abcabcbb" -> 3
 * Constraints: n <= 5e4
 *
 * Key idea:    Sliding window with a set: extend right; on a repeat, shrink from the left
 *              until it's gone. Faster: store each char's last index and jump left =
 *              max(left, last[c] + 1).
 *
 * Approach:    Brute force from every start
 * Complexity:  time O(n^2), space O(charset)
 * Also see:    _1: Window with last-index map (jump left); _2: Window with HashSet (shrink
 *              one by one)
 * Submitted:   2023-12-29 (submission 1131364851, AC)
 */

class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(); 
        int result = 0; 
        HashSet<Character> set = new HashSet<>(); 
        for(int i=0; i<n ;i++){
            set.clear(); 
            for(int j=i; j<n; j++){
                if(set.contains(s.charAt(j))){
                    break; 
                } 
                set.add(s.charAt(j));
                result = Math.max(result,j-i+1); 
            }
        }
        return result; 
    }
}