class Solution {
    char[][] board;
    List<List<String>> result = new LinkedList<>();
    boolean[] lud ; // left upper diagonal 
    boolean[] rdd; // right down diagonal 
    boolean[] lrow; // left row
    public List<List<String>> solveNQueens(int n) {
        this.board = createBoard(n); 
        this.rdd = new boolean[2*n-1]; 
        this.lud = new boolean[2*n-1]; 
        this.lrow = new boolean[n];
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
            if(!rdd[row+col] && !lud[n-1+col-row] && !lrow[row]){
                rdd[row+col] = true;
                lud[n-1+col-row] = true; 
                lrow[row] = true; 

                board[row][col] = 'Q';
                backtrack(col+1,n);
                board[row][col] = '.';

                rdd[row+col] = false;
                lud[n-1+col-row] = false; 
                lrow[row] = false; 
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