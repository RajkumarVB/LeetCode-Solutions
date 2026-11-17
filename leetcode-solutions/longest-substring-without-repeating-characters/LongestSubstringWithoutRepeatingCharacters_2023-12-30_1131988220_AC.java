class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(); 
        int result = 0; 
        HashMap<Character, Integer> map = new HashMap<>(); 
        
        int i=0, j=0; 
        while(j<n){
            char c = s.charAt(j); 
            if(map.containsKey(c)){
                i = Math.max(map.get(c) +1,i); 
            }
            result = Math.max(result, j-i+1); 
            map.put(c,j); 
            j++; 
        }
        return result; 
    }
}
  
   