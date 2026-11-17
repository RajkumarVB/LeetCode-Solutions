class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); 
        Queue<Pair> q = new LinkedList<>(); 
        q.offer(new Pair(beginWord,1)); 
        while(!q.isEmpty()){
            String word = q.peek().word; 
            int level = q.peek().level; 
            q.poll(); 

            if(word.equals(endWord)) return level; 

            char[] wordChars = word.toCharArray(); 
            for(int i=0; i<wordChars.length; i++){
                char original = wordChars[i]; 
                for(char itr = 'a'; itr <= 'z'; itr++){
                    wordChars[i] = itr; 
                    String wordModified = String.valueOf(wordChars); 
                    if(wordSet.contains(wordModified)){
                        wordSet.remove(wordModified);
                        q.offer(new Pair(wordModified,level+1)); 
                    }
                }
                wordChars[i] = original; 
            }
        }
        return 0; 
    }
    record Pair(String word, int level){

    }
}