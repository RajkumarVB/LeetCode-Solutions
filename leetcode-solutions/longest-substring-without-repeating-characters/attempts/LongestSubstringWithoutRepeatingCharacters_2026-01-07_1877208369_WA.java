class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0; 

         
        
        int result = 1; 
        int i = 0; 
        int n = s.length();
        for(; i<n; i++){
            char c = s.charAt(i); 
            HashSet<Character> charsSeen = new HashSet<>();
            charsSeen.add(c);
            int j = i + 1; 
            for(; j<n; j++){
                char c1 = s.charAt(j);
                if(charsSeen.contains(c1)){
                    break;
                }
                int len = j - i + 1; 
                result = Math.max(result, len);
                charsSeen.add(c1); 
            }
            i = j; 
        }
        return result; 
    }
}