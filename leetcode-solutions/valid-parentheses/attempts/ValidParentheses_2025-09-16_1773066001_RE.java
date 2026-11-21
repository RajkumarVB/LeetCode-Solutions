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
                if(stack.getLast() != bracketPairs.get(c)){
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
