class Solution {
    
    private String s; 
    private List<String> wordDict;
    private int n; 
    HashMap<Integer,Boolean> cache = new HashMap<>(); 
    
    
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s; 
        this.wordDict = wordDict; 
        this.n = s.length(); 
        return wordBreak(0); 
    }

    public boolean wordBreak(int i){
        if(i >= n) return true; 
        if(cache.containsKey(i)) return cache.get(i); 
        
        for(String word : wordDict){
            int wLen = word.length(); 
            if(i+wLen <= n && (s.substring(i,i+wLen).equals(word)) ){
               if(wordBreak(i+wLen)){
                   cache.put(i,true); 
                   return true; 
               }
            }
        }
        cache.put(i,false); 
        return false; 
    }
}