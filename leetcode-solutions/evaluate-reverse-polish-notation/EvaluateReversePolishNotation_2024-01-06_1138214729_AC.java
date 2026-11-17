class Solution {
    
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String s : tokens){
            if(isOperator(s)){
                char c = s.charAt(0);
                int arg2 = stack.removeLast();
                int arg1 = stack.removeLast();
                int tempAns;
                if(c == '+'){
                    tempAns = arg1 + arg2 ;
                } else if(c == '-'){
                    tempAns = arg1 - arg2 ;
                } else if(c == '*'){
                    tempAns = arg1 * arg2 ;
                } else{
                    tempAns = arg1 / arg2 ;
                }
                stack.addLast(tempAns);
            } else{
                int number = Integer.parseInt(s);
                stack.addLast(number);
            }
        }
        return stack.getLast();
    }

    public boolean isOperator(String s){
        if(s.length() > 1) return false;
        char c = s.charAt(0);
        return (c == '+') || (c == '-') || (c == '*') || (c == '/');
    }
}