/*
 * 14. Longest Common Prefix  [Easy]
 * https://leetcode.com/problems/longest-common-prefix/
 * Topics: Array, String, Trie
 *
 * Problem:     Return the longest common prefix shared by all strings in the array.
 * Example:     [flower,flow,flight] -> "fl"
 * Constraints: <= 200 strings of length <= 200
 *
 * Key idea:    Vertical scan: compare character i across all strings up to the shortest
 *              length. Trick: after sorting, only the first and last strings need
 *              comparing.
 *
 * Approach:    Sort, compare first and last
 * Complexity:  time O(n log n * L), space O(1)
 * Also see:    _1: Vertical scan up to min length
 * Submitted:   2023-12-22 (submission 1125999443, AC)
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(String s : strs)
            if (s.length()== 0) return ""; 

        Arrays.sort(strs); 
        String first = strs[0];
        String last = strs[strs.length -1 ]; 

        StringBuilder result = new StringBuilder(); 
        for(int i=0 ; i< Math.min(first.length(),last.length()) ; i++){
            if(first.charAt(i) != last.charAt(i)) return result.toString(); 
            result.append(first.charAt(i)); 
        }
        return result.toString(); 
    }
}