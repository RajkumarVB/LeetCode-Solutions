class Solution {
    List<List<String>> result = new LinkedList<>(); 
    public List<List<String>> partition(String s) {
        backtrack(s,0,new LinkedList<>()); 
        return result; 
    }
    public void backtrack(String s, int idx, List<String> tempResult){
        if(idx == s.length()){
            result.add(new LinkedList<>(tempResult));
            return; 
        }
        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s,idx,i)){
                tempResult.add(s.substring(idx,i+1));
                backtrack(s,i+1,tempResult);
                tempResult.removeLast(); 
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false; 
            }
            start ++; 
            end --; 
        }
        return true; 
    }
}