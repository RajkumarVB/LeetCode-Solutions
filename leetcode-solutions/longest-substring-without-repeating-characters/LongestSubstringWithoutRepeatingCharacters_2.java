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
 * Approach:    Window with HashSet (shrink one by one)
 * Complexity:  time O(n), space O(charset)
 * Also see:    _1: Window with last-index map (jump left); _3: Brute force from every start
 * Submitted:   2025-09-13 (submission 1769695181, AC)
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0; 
        int n = s.length(); 
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0; 
        while((left <= right) && (right < n)){
            char c = s.charAt(right); 
            if(!set.contains(c)){
                set.add(c); 
                maxLen = Math.max(maxLen, right - left +1); 
                right ++; 
            }else{
                set.remove(s.charAt(left)); 
                left ++; 
            }
        }
        return maxLen; 
    }
}


