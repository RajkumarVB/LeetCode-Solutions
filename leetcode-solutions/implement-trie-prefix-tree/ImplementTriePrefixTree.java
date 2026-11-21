/*
 * 208. Implement Trie (Prefix Tree)  [Medium]
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * Topics: Hash Table, String, Design, Trie
 *
 * Problem:     Implement a trie with insert(word), search(word) and startsWith(prefix).
 * Example:     insert apple; search apple -> true; search app -> false; startsWith app ->
 *              true
 * Constraints: <= 3e4 calls, lowercase
 *
 * Key idea:    Each node has 26 child links and an end-of-word flag. Walk/create one node
 *              per character; search needs the end flag, startsWith doesn't.
 *
 * Approach:    Array-of-26 children TrieNode
 * Complexity:  time O(L) per op, space O(total chars * 26)
 * Submitted:   2024-02-18 (submission 1178867295, AC)
 */

class TrieNode{
    private TrieNode[] links; 
    private boolean end; 

    public TrieNode(){
        this.links = new TrieNode[26]; 
        this.end = false;
    }

    public boolean containsKey(char c){
        return (links[c - 'a'] != null) ; 
    }

    public void put(char c, TrieNode node){
        links[c - 'a'] = node; 
    }

    public TrieNode get(char c){
        return links[c - 'a']; 
    }
    public void setEnd(){
        this.end = true; 
    }

    public boolean isEnd(){
        return this.end; 
    }
}

class Trie {
    private final TrieNode root; 

    public Trie() {
        this.root = new TrieNode(); 
    }
    
    public void insert(String word) {
        TrieNode itr = root; 
        for(char c : word.toCharArray()){
            if(!itr.containsKey(c)){
                itr.put(c, new TrieNode()); 
            }
            itr = itr.get(c); 
        }
        itr.setEnd(); 
    }
    
    public boolean search(String word) {
        TrieNode itr = root; 
        for(char c : word.toCharArray()){
            if(!itr.containsKey(c)){
                return false; 
            }
            itr = itr.get(c); 
        }
        return itr.isEnd(); 
    }
    
    public boolean startsWith(String prefix) {
        TrieNode itr = root; 
        for(char c : prefix.toCharArray()){
            if(!itr.containsKey(c)){
                return false; 
            }
            itr = itr.get(c); 
        }
        return true; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */