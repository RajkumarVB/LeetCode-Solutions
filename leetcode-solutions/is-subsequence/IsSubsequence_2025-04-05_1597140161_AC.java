class Solution {
    public boolean isSubsequence(String s, String t) {
        int n1 = s.length(); 
        int n2 = t.length(); 
        return isSubsequence(s,t,n1-1, n2-1); 
    }
    private boolean isSubsequence(String s, String t, int i, int j) {
        if(j<0 && i>=0) return false; 
        if(i <0) return true; 
        if(s.charAt(i) == t.charAt(j)){
            return isSubsequence(s,t,i-1,j-1); 
        }
        return isSubsequence(s,t,i,j-1); 
    }
}