/*
 * 3456. Find Special Substring of Length K  [Easy]
 * https://leetcode.com/problems/find-special-substring-of-length-k/
 * Topics: String
 *
 * Problem:     Is there a substring of length exactly k made of one repeated character
 *              whose neighbours (if any) are different characters?
 * Example:     s="aaabaaa", k=3 -> true
 * Constraints: n <= 100
 *
 * Key idea:    Equivalent to: some maximal run of equal characters has length exactly k.
 *              Scan runs in one pass. (Your version checks every window, O(n*k).)
 *
 * Approach:    Check each window of length k and its neighbours
 * Complexity:  time O(n*k), space O(1)
 * Submitted:   2025-02-16 (submission 1544584194, AC)
 */

class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int i=0, j=k-1, n = s.length(); 
        while(j<n){
            boolean isSpecial = true; 
            char windowChar = s.charAt(i); 
            for(int index =i+1; index<=j; index++){
                if(windowChar != s.charAt(index)){
                    isSpecial = false;
                    break; 
                }
            }
            if(isSpecial == true && i !=0 && s.charAt(i-1) == windowChar){
                isSpecial = false;
            }

            if(isSpecial == true && j != n-1 && s.charAt(j+1) == windowChar){
                isSpecial = false;
            }

            if(isSpecial == true){
                return true; 
            }

            j++;
            i++; 
        }
        return false; 
    }
}
