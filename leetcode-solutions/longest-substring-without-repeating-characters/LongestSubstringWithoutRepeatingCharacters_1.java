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
 * Approach:    Window with last-index map (jump left)
 * Complexity:  time O(n), space O(charset)
 * Also see:    _2: Window with HashSet (shrink one by one); _3: Brute force from every
 *              start
 * Submitted:   2023-12-30 (submission 1131988220, AC)
 */

class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(); 
        int result = 0; 
        HashMap<Character, Integer> map = new HashMap<>(); 
        
        int i=0, j=0; 
        while(j<n){
            char c = s.charAt(j); 
            if(map.containsKey(c)){
                i = Math.max(map.get(c) +1,i); 
            }
            result = Math.max(result, j-i+1); 
            map.put(c,j); 
            j++; 
        }
        return result; 
    }
}
  
   