/*
 * 127. Word Ladder  [Hard]
 * https://leetcode.com/problems/word-ladder/
 * Topics: Hash Table, String, Breadth-First Search, Bidirectional Search
 *
 * Problem:     Return the number of words in the shortest sequence from beginWord to
 *              endWord where each step changes one letter and every word is in the list, or
 *              0.
 * Example:     hit -> cog with [hot,dot,dog,lot,log,cog] -> 5
 * Constraints: word length <= 10, <= 5000 words
 *
 * Key idea:    BFS over words. For each position try all 26 letters; if the new word is in
 *              the set, enqueue it and remove it from the set (that marks it visited).
 *
 * Approach:    BFS trying 26 letters per position
 * Complexity:  time O(N * L * 26), space O(N)
 * Submitted:   2024-03-28 (submission 1216595048, AC)
 */

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