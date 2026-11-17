class Solution {
    
    private String s; 
    private List<String> wordDict;
    private int n; 
    private int[] dp; 
    
    
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s; 
        this.wordDict = wordDict; 
        this.n = s.length(); 
        dp = new int[n+1]; 
        Arrays.fill(dp,-1); 
        dp[n] = 1; 
        // 1 - true
        // 0 - false 
        // -1 - not computed yet


        return wordBreak(0); 
    }

    public boolean wordBreak(int i){
        if(dp[i] == 1) return true; 
        if(dp[i] ==0) return false; 

        for(String word : wordDict){
            int wLen = word.length(); 
            if(i+wLen <= n && (s.substring(i,i+wLen).equals(word)) ){
               if(wordBreak(i+wLen)){
                   dp[i] = 1; 
                   return true; 
               }
            }
        }
        dp[i] = 0; 
        return false; 
    }
}