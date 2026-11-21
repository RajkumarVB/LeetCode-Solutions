/*
 * 76. Minimum Window Substring  [Hard]
 * https://leetcode.com/problems/minimum-window-substring/
 * Topics: Hash Table, String, Sliding Window
 *
 * Problem:     Return the shortest substring of s containing every character of t (with
 *              multiplicity), or "".
 * Example:     s="ADOBECODEBANC", t="ABC" -> "BANC"
 * Constraints: lengths <= 1e5
 *
 * Key idea:    Variable sliding window with counts. 'have' = number of characters whose
 *              required count is met, 'need' = distinct characters in t. Expand right;
 *              while have == need, record the answer and shrink from the left.
 *
 * Approach:    Sliding window with have/need counters
 * Complexity:  time O(m + n), space O(charset)
 * Submitted:   2025-09-16 (submission 1772249551, AC)
 */

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for(char c : t.toCharArray()){
            int count = targetMap.getOrDefault(c, 0);
            targetMap.put(c, count + 1);
        }

        int have = 0;
        int need = targetMap.size();

        int left =0, right = 0;
        int startingPoint = -1, resultLength = Integer.MAX_VALUE;

        for(; right < s.length(); right++){
            int count = windowMap.getOrDefault(s.charAt(right), 0);
            windowMap.put(s.charAt(right), count + 1);
            count ++ ;
            if(count == targetMap.getOrDefault(s.charAt(right), 0)){
                have ++;
            }

            // shrinking the window
            while(have == need && left <= right){
                if(have >= need && (right - left + 1) < resultLength ){
                    startingPoint = left;
                    resultLength = right - left + 1;
                }

                count = windowMap.getOrDefault(s.charAt(left), 0);
                windowMap.put(s.charAt(left), count - 1);
                count --;
                if(count + 1 == targetMap.getOrDefault(s.charAt(left), 0)){
                    have --;
                }
                left ++;
            }
        }

        return (startingPoint == -1) ? "" : s.substring(startingPoint, startingPoint + resultLength);

    }
}