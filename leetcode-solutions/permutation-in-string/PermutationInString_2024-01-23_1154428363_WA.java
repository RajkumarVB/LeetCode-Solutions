class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length(); 
        if(m < n) return false; 
        int i =0; 
        int j = n-1; 
        while(j < m){
            if(isValid(s1,s2.substring(i,j+1))) return true;
            j++;
            i++;
        }
        return false;
    }
    public boolean isValid(String s1, String s2){
        if(s1.length() != s2.length()) return false; 
        int[] charCount = new int[26];
        for(int i=0; i<s1.length(); i++){
            charCount[s1.charAt(i) - 'a'] ++; 
            charCount[s2.charAt(i) - 'a'] --; 
        }
        for(int i=0; i<s1.length(); i++){
            if(charCount[i] !=0) return false;
        }
        return true; 
    }
}