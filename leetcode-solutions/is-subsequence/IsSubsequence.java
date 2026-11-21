/*
 * 392. Is Subsequence  [Easy]
 * https://leetcode.com/problems/is-subsequence/
 * Topics: Two Pointers, String, Dynamic Programming
 *
 * Problem:     Return true if s can be obtained from t by deleting some characters without
 *              reordering.
 * Example:     s="abc", t="ahbgdc" -> true
 * Constraints: |s| <= 100, |t| <= 1e4
 *
 * Key idea:    Two pointers: advance through t and move the s pointer whenever characters
 *              match. s is a subsequence if its pointer reaches the end.
 *
 * Approach:    Recursive two pointers from the end
 * Complexity:  time O(|t|), space O(|t|) stack
 * Submitted:   2025-04-05 (submission 1597140161, AC)
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        int n1 = s.length(); 
        int n2 = t.length(); 
        return isSubsequence(s,t,n1-1, n2-1); 
    }
    private boolean isSubsequence(String s, String t, int i, int j) {
        if(j<0 && i>=0) return false; 
        if(i <0) return true; 
        if(s.charAt(i) == t.charAt(j)){
            return isSubsequence(s,t,i-1,j-1); 
        }
        return isSubsequence(s,t,i,j-1); 
    }
}