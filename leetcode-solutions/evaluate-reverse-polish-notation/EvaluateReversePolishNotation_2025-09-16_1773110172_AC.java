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