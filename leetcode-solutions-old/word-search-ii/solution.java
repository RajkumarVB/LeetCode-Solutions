class TrieNode{
    TrieNode[] links;
    boolean isEnd; 

    public TrieNode(){
        links = new TrieNode[26];
        isEnd = false; 
    }
    public boolean containsKey(char ch){
        if(links[ch - 'a'] == null) return false; 
        return true; 
    }
    public TrieNode get(char ch){
        return (links[ch - 'a']);
    }
    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node; 
    }
    public boolean isWord(){
        return isEnd; 
    }
    public void setEnd(){
        isEnd = true; 
    }
}
class Trie{
    TrieNode root = new TrieNode(); 
    public void addWord(String word){
        TrieNode itr = root; 
        for(char c : word.toCharArray()){
            if(!itr.containsKey(c)){
                itr.put(c, new TrieNode()); 
            }
            itr = itr.get(c); 
        }
        itr.setEnd(); 
    }
}

class Solution {
    HashSet<String> result = new HashSet<>(); 
    int ROWS;
    int COLS; 
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie(); 
        int n = board.length; 
        int m = board[0].length; 
        this.ROWS = n; 
        this.COLS = m; 
        boolean[][] visited = new boolean[n][m]; 
        
        for(String word : words){
            trie.addWord(word); 
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dfs(i,j,board,new StringBuilder(), visited, trie.root); 
            }
        }
        return new LinkedList<>(result); 
    }

    public void dfs(int r, int c, char[][] board, StringBuilder word, boolean[][] visited, TrieNode root){
        if(r <0 || c <0 || r>= ROWS || c >= COLS || 
            !root.containsKey(board[r][c]) || 
            visited[r][c]
        ) return; 

        word.append(board[r][c]);
        visited[r][c] = true; 
        TrieNode node = root.get(board[r][c]);

        if(node.isWord()){
            result.add(word.toString());
        }
        dfs(r+1, c, board, word, visited,node);
        dfs(r, c+1, board, word, visited,node);
        dfs(r-1, c, board, word, visited,node);
        dfs(r, c-1, board, word, visited,node);


        word.deleteCharAt(word.length() -1);
        visited[r][c] = false; 
    }
}