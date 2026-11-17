class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(); 
        int[] dp = new int[n];
        Arrays.fill(dp,-1); 
        return isPossible(0,s,wordDict,dp);
    }
    public boolean isPossible(int start, String s, List<String> wordDict,int[] dp){
        int n = s.length(); 
        if(start >=n) return true; 
        if(dp[start] ==0 ) return false; 
        if(dp[start] == 1)  return true; 
        for(String word : wordDict){
            int wLen = word.length(); 
            if(start + wLen <= n && s.substring(start, start+wLen).equals(word)){
                if(isPossible(start+wLen, s, wordDict,dp)){
                    dp[start] = 1; 
                    return true; 
                }
            }
        }
        dp[start] = 0; 
        return false; 
    }
}