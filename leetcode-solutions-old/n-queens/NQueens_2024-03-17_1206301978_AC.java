class Solution {
    char[][] board;
    List<List<String>> result = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        this.board = createBoard(n); 
        backtrack(0,n);
        return result; 
    }
    public void backtrack(int col, int n){
        if(col == n){
            // Placed all the queens. 
            saveAns(); 
            return; 
        }
        for(int row=0; row<n; row++){
            if(isSafe(row,col,n)){
                board[row][col] = 'Q';
                backtrack(col+1,n);
                board[row][col] = '.';
            }
        }
    }

    public void saveAns(){
        List<String> ans = new LinkedList<>();
        for(int i=0; i<board.length; i++){
            String temp = new String(board[i]);
            ans.add(temp);
        }
        result.add(ans);
    }

    public boolean isSafe(int row, int col, int n){
        int i = row-1, j = col-1; 
        // Left Upper Diagnol
        while(i>=0 && j >= 0){
            if(board[i][j] == 'Q') return false; 
            i--;
            j--; 
        }
        i=row; j=col-1;
        // Same Row leftwards
        while(i>=0 && j >= 0){
            if(board[i][j] == 'Q') return false; 
            j --; 
        }
        i=row+1; j=col-1;
        // Right Down Diagnol
        while(i<n && j>= 0){
            if(board[i][j] == 'Q') return false;
            i++; 
            j--; 
        }
        return true; 
    }
    public char[][] createBoard(int n){
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.'; 
            }
        }
        return board; 
    }
}