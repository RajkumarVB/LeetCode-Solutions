class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(); 
        int[] dp = new int[n+1];
        dp[n] = 1; 
        
        for(int start=n-1; start>=0; start--){
            for(String word : wordDict){
                int wLen = word.length(); 
                if(start + wLen <= n && s.substring(start, start+wLen).equals(word)){
                    dp[start] = dp[start+wLen]; 
                }
                if(dp[start] == 1) break; 
            }   
        }
        return dp[0] ==1; 
    }
}