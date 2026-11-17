class Solution {
    public int countSubstrings(String s) {
        int n = s.length(); 
        int result =0; 
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalindrome(s.substring(i,j+1))){
                    result ++; 
                }
            }
        }
        return result; 
    }
    public boolean isPalindrome(String s){
        int n = s.length();
        int left = 0, right = n-1; 
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false; 
            }
            left ++; 
            right --; 
        }
        return true; 
    }
}