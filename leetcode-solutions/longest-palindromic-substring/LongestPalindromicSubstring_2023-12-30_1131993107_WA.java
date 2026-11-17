class Solution {
    public String longestPalindrome(String s) {
        int i = 0, j = s.length() -1; 
        while(i < j){
            if(isPalindrome(s,i,j)) return s.substring(i,j+1); 
            i ++; j--; 
        }
        return ""; 
    }
    public static boolean isPalindrome(String s, int i, int j){
        while(i <j){
            if(s.charAt(i) != s.charAt(j)) return false; 
            i ++; 
            j --; 
        }
        return true; 
    }
}