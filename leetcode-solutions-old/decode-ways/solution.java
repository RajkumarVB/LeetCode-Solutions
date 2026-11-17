class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n]; 
        Arrays.fill(dp,-1); 
        return noOfWays(s,0,n,dp); 
    }
    public int noOfWays(String s, int i, int n, int[] dp){
        if(i>=n) return 1; 
        if(dp[i] != -1) return dp[i]; 
        char first = s.charAt(i); 
        int result = 0; 
        if(first != '0') result += noOfWays(s,i+1,n,dp); 
        if(i + 1 < n){
            char second = s.charAt(i+1); 
            if(first == '1' || first == '2' && (second >='0' && second <= '6')){
                result += noOfWays(s,i+2,n,dp); 
            }
        }
        return dp[i] = result; 
    }
}