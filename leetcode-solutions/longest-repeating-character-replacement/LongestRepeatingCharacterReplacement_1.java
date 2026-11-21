/*
 * 424. Longest Repeating Character Replacement  [Medium]
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * Topics: Hash Table, String, Sliding Window
 *
 * Problem:     You may change at most k characters. Return the longest substring that can
 *              be made of one repeated letter.
 * Example:     "AABABBA", k=1 -> 4
 * Constraints: n <= 1e5, uppercase
 *
 * Key idea:    Sliding window: it's valid while windowLen - maxFreq <= k. Grow the right
 *              edge; if invalid, move left once. maxFreq never needs to decrease, because
 *              only a larger maxFreq can give a longer answer.
 *
 * Approach:    Sliding window with running maxFreq
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: Sliding window, recompute max over 26 counts
 * Submitted:   2025-09-14 (submission 1770807980, AC)
 */

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(); 
        int left = 0, right = 0, result = 0; 
        int maxFrequency  =0 ; // maxFrequency int that particular window 
        int[] frequency = new int[26]; 
        while(right < n){
            char c = s.charAt(right); 
            frequency[c-'A']++; 
            maxFrequency = Math.max(maxFrequency, frequency[c-'A']); 
            int replacementsNeeded = (right - left + 1) - maxFrequency; 
            if((right - left + 1) - maxFrequency > k){
                    frequency[s.charAt(left) - 'A']--; 
                    left ++ ; 
            }
            result = Math.max(result, right - left + 1); 
            right++; 
            
        }
        return result; 
    }
}
