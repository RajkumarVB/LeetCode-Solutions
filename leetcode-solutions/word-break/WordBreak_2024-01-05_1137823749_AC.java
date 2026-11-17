class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(); 
        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for(int i=n-1;i>=0; i--){
            for(String word : wordDict){
                int wLen = word.length(); 
                if(i+wLen <=n && s.substring(i, i+wLen).equals(word)){
                    dp[i] = dp[i+wLen]; 
                }
                if(dp[i] == true) break; 
            }
        }

        return dp[0]; 
    }
}