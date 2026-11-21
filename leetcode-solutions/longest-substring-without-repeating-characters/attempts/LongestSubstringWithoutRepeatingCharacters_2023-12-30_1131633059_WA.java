class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int i =0, j =0;
        while(j<n){
            if(map.containsKey(s.charAt(j))){
                i = map.get(s.charAt(j)) + 1; 
                map.remove(s.charAt(j));
            } else{
                result = Math.max(result, j-i+1);
                map.put(s.charAt(j),j); 
                j++;
            }
        }
        return result;
    }
}
  
   