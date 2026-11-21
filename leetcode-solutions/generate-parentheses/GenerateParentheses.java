/*
 * 22. Generate Parentheses  [Medium]
 * https://leetcode.com/problems/generate-parentheses/
 * Topics: String, Dynamic Programming, Backtracking, Bracket Sequences
 *
 * Problem:     Generate all well-formed strings of n pairs of parentheses.
 * Example:     n=3 -> [((())), (()()), (())(), ()(()), ()()()]
 * Constraints: n <= 8
 *
 * Key idea:    Backtrack on counts: add '(' while open < n, add ')' while close < open.
 *              Every string built this way is valid.
 *
 * Approach:    Backtracking with open/close counts
 * Complexity:  time O(4^n / sqrt(n)), space O(n)
 * Submitted:   2025-09-17 (submission 1774184084, AC)
 */

class Solution {
    private List<String> result; 
    public List<String> generateParenthesis(int n) {
        result = new LinkedList<>(); 
        generate(n, 0,0, new StringBuilder()); 
        return result; 
    }

    private void generate(int n, int openUsed , int closedUsed, StringBuilder tempResult){
        if(openUsed ==n && closedUsed ==n ){
            result.add(tempResult.toString()); 
            return; 
        }
        if(openUsed < n){
            tempResult.append('('); 
            generate(n, openUsed + 1, closedUsed,tempResult); 
            tempResult.deleteCharAt(tempResult.length()-1); 
        }
       

        if(closedUsed < openUsed){
            tempResult.append(')'); 
            generate(n, openUsed, closedUsed + 1,tempResult); 
            tempResult.deleteCharAt(tempResult.length()-1); 
        }
    }
}
