class Solution {
    public boolean isPalindrome(String s) {
        int left =0, right = s.length() -1; 
        while(left < right){
            if(!isAlphaNumberic(s.charAt(left))){
                left ++;    
                continue; 
            }
            if(!isAlphaNumberic(s.charAt(right))){
                right --;    
                continue; 
            }
            
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if(isUpperCase(c1)) c1 = Character.toLowerCase(c1);
            if(isUpperCase(c2)) c2 = Character.toLowerCase(c2);

            if(c1 != c2) return false; 
            
            left ++; 
            right --; 

        }
        return true; 
    }
    public static boolean isAlphaNumberic(char c){
        if(c >= 'A' && c<='Z' || c >= 'a' && c<='z' || c >= '0' && c<='9') return true; 
        return false; 
    }
    public static boolean isUpperCase(char c){
        if(c >= 'A' && c<='Z') return true; 
        return false; 
    }
}