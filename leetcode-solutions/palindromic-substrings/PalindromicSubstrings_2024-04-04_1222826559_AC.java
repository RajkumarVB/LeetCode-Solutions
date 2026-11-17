class Solution {
    int palindromeCount = 0; 
    public int countSubstrings(String s) {
        int n = s.length(); 
        for(int i=0; i<n; i++){
            expandRange(i,i+1,s); // even length palindrome 
            expandRange(i,i,s); // odd length palindrome 
        }
        return palindromeCount; 
    }

    public void expandRange(int mid1, int mid2, String s){
        int n = s.length();
        if(mid2 >= n) return; 
        int palindromeLen = 0; 
        while(mid1 >= 0 && mid2 < n){
            if(s.charAt(mid1) != s.charAt(mid2)){
                break;
            }
            palindromeCount ++; 
            mid1 --; 
            mid2 ++; 
        }
    }
}