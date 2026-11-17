class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(); 
        int result = 0; 
        HashSet<Character> set = new HashSet<>(); 
        for(int i=0; i<n ;i++){
            set.clear(); 
            for(int j=i; j<n; j++){
                if(set.contains(s.charAt(j))){
                    break; 
                } 
                set.add(s.charAt(j));
                result = Math.max(result,j-i+1); 
            }
        }
        return result; 
    }
}