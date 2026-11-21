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