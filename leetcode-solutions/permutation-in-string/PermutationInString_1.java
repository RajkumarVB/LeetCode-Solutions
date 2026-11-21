/*
 * 567. Permutation in String  [Medium]
 * https://leetcode.com/problems/permutation-in-string/
 * Topics: Hash Table, Two Pointers, String, Sliding Window
 *
 * Problem:     Does s2 contain some permutation of s1 as a substring?
 * Example:     s1="ab", s2="eidbaooo" -> true
 * Constraints: lengths <= 1e4
 *
 * Key idea:    Fixed-size sliding window of length |s1| with 26-letter counts. Track
 *              'matches' (how many of the 26 counts are equal) so each slide is O(1); found
 *              when matches == 26.
 *
 * Approach:    Fixed window + matches counter
 * Complexity:  time O(n + m), space O(1)
 * Also see:    _2: Fixed window, compare 26 counts each slide; _3: Brute force: check every
 *              substring
 * Submitted:   2025-09-15 (submission 1771908370, AC)
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Count initial window
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matchingChars = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) matchingChars++;
        }

        int windowStart = 0;
        for (int windowEnd = s1.length(); windowEnd < s2.length(); windowEnd++) {
            if (matchingChars == 26) return true;

            // remove char from left
            int leftIndex = s2.charAt(windowStart) - 'a';
            if (s1Count[leftIndex] == s2Count[leftIndex]) matchingChars--;
            s2Count[leftIndex]--;
            if (s1Count[leftIndex] == s2Count[leftIndex]) matchingChars++;
            windowStart++;

            // add char from right
            int rightIndex = s2.charAt(windowEnd) - 'a';
            if (s1Count[rightIndex] == s2Count[rightIndex]) matchingChars--;
            s2Count[rightIndex]++;
            if (s1Count[rightIndex] == s2Count[rightIndex]) matchingChars++;
        }

        return matchingChars == 26;
    }
}
