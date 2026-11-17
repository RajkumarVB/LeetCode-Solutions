class Solution {
    public void solveSudoku(char[][] board) {
        solve(board); 
    }
    private boolean solve(char[][] board){
        int n = board.length; 
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k<='9'; k++){
                        if(placingPossilbe(board,i,j,k)){
                            board[i][j] = k; 
                            boolean solvedInThisPath = solve(board);
                            if(solvedInThisPath) return true; 
                            board[i][j] = '.';
                        }
                    }
                    return false; 
                }
            }
        }
        return true; 
    }

    private boolean placingPossilbe(char[][] board, int row, int col, char k){
        int startRow = (row / 3) * 3; 
        int startCol = (col / 3) * 3; 
        
        for(int i=0; i<9; i++){
            if(board[row][i] == k || board[i][col] == k) return false; 
            if(board[startRow + (i/3)][startCol + (i %3)] == k ) return false; 
        }
        return true; 
    }
}