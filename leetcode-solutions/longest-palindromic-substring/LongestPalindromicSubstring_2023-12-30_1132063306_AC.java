class Solution {
    int resultStart =-1; 
    int resultEnd = -1; 
    int resultLength = 0; 
    
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i=0; i<n; i++){
            expandRange(s,i,i);
            expandRange(s,i,i+1);
        }
        return s.substring(resultStart, resultEnd+1);
    }
    public void expandRange(String s, int left, int right){
        int n = s.length();
        if(left < 0 || right > n-1) return;

        while(left >=0 && right <n && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }

        if((right - left - 1) > resultLength){
            resultStart = left + 1;
            resultEnd = right -1;
            resultLength = right - left - 1;
        }
    }
}