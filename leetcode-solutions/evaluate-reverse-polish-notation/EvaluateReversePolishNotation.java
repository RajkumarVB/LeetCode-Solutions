/*
 * 150. Evaluate Reverse Polish Notation  [Medium]
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Topics: Array, Math, Stack
 *
 * Problem:     Evaluate an arithmetic expression given in Reverse Polish (postfix)
 *              notation, with integer division truncating toward zero.
 * Example:     ["2","1","+","3","*"] -> 9
 * Constraints: <= 1e4 tokens
 *
 * Key idea:    Push numbers onto a stack; on an operator pop b then a (order matters for -
 *              and /), push a op b.
 *
 * Approach:    Operand stack
 * Complexity:  time O(n), space O(n)
 * Submitted:   2025-09-16 (submission 1773110172, AC)
 */

class Solution {
    public int evalRPN(String[] tokens) {
       LinkedList<Integer> stack = new LinkedList<>(); 
        for(String s : tokens){
            // check if the string is a operator
            if(isOperator(s)){
                int operand2 = stack.removeLast();
                int operand1 = stack.removeLast();
                int result = 0; 
                if(s.charAt(0) == '+'){
                    result = operand1 + operand2; 
                }else if(s.charAt(0) == '-'){
                    result = operand1 - operand2; 
                }else if(s.charAt(0) == '*'){
                    result = operand1 * operand2; 
                }else if(s.charAt(0) == '/'){
                    result = operand1 / operand2; 
                }
                stack.addLast(result);
            }else{
                stack.addLast(Integer.valueOf(s)); 
            }
        }
        return stack.getLast(); 
    }
    private boolean isOperator(String s){
        HashSet<Character> operators = new HashSet<>(); 
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');

        if(s.length() ==1 && operators.contains(s.charAt(0))){
            return true; 
        }
        return false; 
    }
}