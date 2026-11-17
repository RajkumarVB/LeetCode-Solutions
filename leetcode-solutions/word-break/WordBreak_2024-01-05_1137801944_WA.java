class Solution {
    
    private String s; 
    private List<String> wordDict;
    private int n; 
    
    
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s; 
        this.wordDict = wordDict; 
        this.n = s.length(); 
        return wordBreak(0); 
    }

    public boolean wordBreak(int i){
        if(i >= n) return true; 

        boolean isMatchFound = false; 
        int matchFoundLen = 0; 
        for(String word : wordDict){
            int wLen = word.length(); 
            if(i+wLen <= n && (s.substring(i,i+wLen).equals(word)) ){
                matchFoundLen = wLen; 
                isMatchFound = true; 
                break; 
            }
        }
        if(isMatchFound){
            return wordBreak(i+matchFoundLen); 
        }
        return false; 
    }

}