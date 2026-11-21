class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        long wordDictWordsLength = 0; 
        long sLength = s.length();
        for(String word : wordDict){
            if(!s.contains(word)) return false; 
            wordDictWordsLength += word.length(); 
        }
        if(wordDictWordsLength > sLength) return false; 
        return true; 
    }
}