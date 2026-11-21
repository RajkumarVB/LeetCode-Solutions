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
 * Approach:    Sliding window, recompute max over 26 counts
 * Complexity:  time O(26n), space O(1)
 * Also see:    _1: Sliding window with running maxFreq
 * Submitted:   2024-01-22 (submission 1153811872, AC)
 */

class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26]; 
        int n = s.length(); 
        int i, j; 
        i=0; j=0; 
        int maxWindow =0; 
        while(j < n){
            char c = s.charAt(j); 
            charCount[c - 'A']++; 
            int maxFreq = getMaxFreq(charCount);
            int windowLen = j -i +1; 
            if(windowLen - maxFreq <= k){
                maxWindow = Math.max(maxWindow, windowLen);
                j++; 
            } else{
                char ci = s.charAt(i); 
                charCount[ci - 'A'] --; 
                charCount[c - 'A'] -- ; 
                i++; 
            }
        }
        return maxWindow; 
    }
    public int getMaxFreq(int[] charCount){
        int result =0; 
        for(int i=0; i<charCount.length; i++){
            result = Math.max(result,charCount[i]); 
        }
        return result; 
    }
}