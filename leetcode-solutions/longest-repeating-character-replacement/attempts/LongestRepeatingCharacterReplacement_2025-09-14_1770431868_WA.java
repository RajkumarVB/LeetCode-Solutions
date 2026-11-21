class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n == 0) return 0; 
        int left = 0, right =0; 
        char startingChar = s.charAt(left); 
        int currentExceptionCount = 0; 
        int result = 1; 
        for(; right<n ; right++){
            char currentChar = s.charAt(right); 
            if(currentChar == startingChar || currentExceptionCount < k){
                if(currentChar != startingChar) currentExceptionCount++; 
                result = Math.max(result, right - left + 1) ; 
            }else{
                left = right; 
                currentChar = s.charAt(left); 
                currentExceptionCount = 0; 
            }
        }
        return result; 
    }
}