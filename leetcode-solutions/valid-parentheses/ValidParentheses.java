/*
 * 20. Valid Parentheses  [Easy]
 * https://leetcode.com/problems/valid-parentheses/
 * Topics: String, Stack, Bracket Sequences
 *
 * Problem:     Return whether a string of ()[]{} brackets is properly matched and nested.
 * Example:     "()[]{}" -> true; "(]" -> false
 * Constraints: n <= 1e4
 *
 * Key idea:    Push openers onto a stack. On a closer, the top must be its matching opener
 *              (pop); otherwise it's invalid. Valid only if the stack is empty at the end.
 *
 * Approach:    Stack with closer->opener map
 * Complexity:  time O(n), space O(n)
 * Submitted:   2025-09-16 (submission 1773066996, AC)
 */

class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> bracketPairs = new HashMap<>(); 
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');

        LinkedList<Character> stack = new LinkedList<>();
        for(char c : s.toCharArray()){
            if(bracketPairs.containsKey(c)){
                // this is a closed bracket
                // check if the corresponding pair is there in stacks top
                if(stack.isEmpty() || stack.getLast() != bracketPairs.get(c)){
                    return false; 
                }
                stack.removeLast();
            }else{
                stack.addLast(c);
            }
            
        }
        return stack.isEmpty();
    }
}


// invalid cases 
// )(
// (
