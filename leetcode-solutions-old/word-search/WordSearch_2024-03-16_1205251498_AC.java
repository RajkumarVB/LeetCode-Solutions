class Solution {
    char[][] board;
    String word; 
    int m; 
    int n; 
    public boolean exist(char[][] board, String word) {
        this.board = board; 
        this.word = word; 
        this.m = board.length; 
        this.n = board[0].length; 

        for(int i=0; i<m ;i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0) == board[i][j]){
                    if(dfs(i,j,0)) return true; 
                }
            }
        }
        return false; 
    }
    public boolean dfs(int i, int j, int idx){
        if(idx == word.length()) return true; 
        if(i < 0 || i >=m || j<0 || j>=n || word.charAt(idx) != board[i][j]) return false; 
        board[i][j] += 100; 
        boolean result = dfs(i+1,j,idx+1) || dfs(i-1,j,idx+1) || dfs(i,j+1,idx+1) || dfs(i,j-1,idx+1); 
        board[i][j] -= 100; 
        return result; 
    }
}