/*
 * 678. Valid Parenthesis String  [Medium]
 * https://leetcode.com/problems/valid-parenthesis-string/
 * Topics: String, Dynamic Programming, Stack, Greedy, Bracket Sequences
 *
 * Problem:     A string has '(', ')' and '*' where '*' can be '(', ')' or empty. Is it a
 *              valid parentheses string?
 * Example:     "(*))" -> true
 * Constraints: n <= 100
 *
 * Key idea:    Greedy range: track the min and max possible number of open brackets. '('
 *              adds 1 to both, ')' subtracts 1 from both, '*' does lo-1 and hi+1. If hi <
 *              0, fail; clamp lo at 0. Valid if lo == 0 at the end.
 *
 * STATUS:      NOT ACCEPTED - this is your latest attempt. Earlier attempts are in
 *              attempts/.
 * Submitted:   2024-02-29 (submission 1189920528, WA)
 */

class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Deque<Character> stack = new LinkedList<>(); 
        int missCount = 0; 
        for(int i=0; i<n; i++){
            char c = s.charAt(i); 
            if(c == '*'){
                missCount++; 
                continue; 
            }
            if(c == '('){
                stack.addLast(c); 
            } else{
                if(stack.size() ==0) missCount--; 
                else stack.removeLast(); 
            }
            if(missCount < 0) return false; 
        }
        if(stack.size() <= missCount) return true; 
        return false; 

    }
}