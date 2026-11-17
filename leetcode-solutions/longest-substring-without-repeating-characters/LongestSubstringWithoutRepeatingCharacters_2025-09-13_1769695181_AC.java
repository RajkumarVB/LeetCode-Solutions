class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0; 
        int n = s.length(); 
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0; 
        while((left <= right) && (right < n)){
            char c = s.charAt(right); 
            if(!set.contains(c)){
                set.add(c); 
                maxLen = Math.max(maxLen, right - left +1); 
                right ++; 
            }else{
                set.remove(s.charAt(left)); 
                left ++; 
            }
        }
        return maxLen; 
    }
}


