class Solution {
    
    private String s; 
    private List<String> wordDict;
    private int n; 
    private boolean[] dp; 
    
    
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s; 
        this.wordDict = wordDict; 
        this.n = s.length(); 
        dp = new boolean[n+1];
        dp[n] = true; 


        return wordBreak(0); 
    }

    public boolean wordBreak(int i){
        if(dp[i] == true) return true; 

        for(String word : wordDict){
            int wLen = word.length(); 
            if(i+wLen <= n && (s.substring(i,i+wLen).equals(word)) ){
               if(wordBreak(i+wLen)){
                   dp[i] = true; 
                   return true; 
               }
            }
        }
        dp[i] = false; 
        return false; 
    }
}