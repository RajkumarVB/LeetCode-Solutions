class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if(m > n ) return -1; 

        int firstChar = needle.charAt(0); 
        for(int i=0; i<n ; i++){
            char c = haystack.charAt(i); 
            if(firstChar == c){
                if(isPresent(haystack,needle,i)) return i; 
            }
        }
        return -1; 
    }
    public static boolean isPresent(String s1, String s2, int i){
        int n = s1.length();
        int m = s2.length();
        
        if(i+m > n) return false; 
        return s1.substring(i,i+m).equals(s2); 
    }
}