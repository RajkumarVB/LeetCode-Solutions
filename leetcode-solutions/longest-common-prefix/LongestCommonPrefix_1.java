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
 * Approach:    Vertical scan up to min length
 * Complexity:  time O(total chars), space O(1)
 * Also see:    _2: Sort, compare first and last
 * Submitted:   2026-09-02 (submission 2128702044, AC)
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE; 
        for(String str : strs){
            minLength = Math.min(str.length(), minLength);
        }
        StringBuilder str = new StringBuilder();
        for(int i=0; i<minLength; i++){
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length; j++){
                if(c != strs[j].charAt(i)){
                    return str.toString();
                }
            }
            str.append(c); 
        }
        return str.toString();
    }
}