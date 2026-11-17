class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int n = s.length();
        HashMap<Character,Character> comp = new HashMap<>(); 
        comp.put(')', '(');
        comp.put(']', '[');
        comp.put('}', '{');

        
        for(char c : s.toCharArray()){
            if(c == '(' || c =='{' || c == '['){
                stack.addLast(c); 
            } else {
                if(!stack.isEmpty() && stack.getLast() == comp.get(c)){
                    stack.removeLast(); 
                } else{
                    return false; 
                }
            }
        }

        return stack.isEmpty(); 
    }
}