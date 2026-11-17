class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false; 
        HashMap<Character, Character> map = new HashMap<>(); 
        initializeMap(map); 
        
        Deque<Character> stack = new LinkedList<>(); 

        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                // The current character is a closing bracket. 
                if(stack.isEmpty() || stack.getLast() != map.get(c)) return false; 
                stack.removeLast(); 
            } else{
                // The current character is a opening bracket. 
                stack.addLast(c); 
            }
        }

        return stack.isEmpty(); 
    }

    public static void initializeMap(HashMap<Character, Character> map){
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
    }
}