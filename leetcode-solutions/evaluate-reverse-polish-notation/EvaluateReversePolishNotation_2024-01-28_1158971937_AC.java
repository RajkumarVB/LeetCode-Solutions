class Solution {
    public int evalRPN(String[] tokens) {
        List<Integer> stack = new LinkedList<>();
        for(String s : tokens){
            if(isOperator(s)){
                int arg2 = stack.removeLast();
                int arg1 = stack.removeLast();
                char operator = s.charAt(0); 
                if(operator == '+'){
                    stack.addLast(arg1 + arg2); 
                } else if(operator == '-'){
                    stack.addLast(arg1 - arg2); 
                } else if(operator == '*'){
                    stack.addLast(arg1 * arg2); 
                } else {
                    stack.addLast(arg1 / arg2); 
                }
            } else{
                stack.addLast(Integer.valueOf(s)); 
            }
        }
        return stack.getLast(); 
    }
    public boolean isOperator(String s){
        if(s.length() != 1 ) return false; 
        char c = s.charAt(0); 
        if(c == '+' || c == '-' || c == '*' || c == '/') return true; 
        return false; 
    }
}