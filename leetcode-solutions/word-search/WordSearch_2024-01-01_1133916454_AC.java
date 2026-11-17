class Solution {
    private char[][] board;
    private String word;
    private int m, n;  
    public boolean exist(char[][] board, String word) {
        this.board = board; 
        this.word = word; 
        this.m = board.length; 
        this.n = board[0].length; 


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0) && dfs(i,j,0)){
                    return true; 
                }
            }
        }
        return false; 

    }

    public boolean dfs(int i, int j, int wordPos){
        if(wordPos == word.length()) return true;
        
        Pair p = new Pair(i,j);
        if(i >= m || i<0 || j>=n || j<0  || word.charAt(wordPos) != board[i][j]) return false; 

        board[i][j] += 100; 
        boolean result = dfs(i+1,j,wordPos+1) || dfs(i-1,j,wordPos+1) || dfs(i,j+1,wordPos+1) || dfs(i,j-1,wordPos+1); 
        board[i][j] -= 100; 

        return result; 
    }
}