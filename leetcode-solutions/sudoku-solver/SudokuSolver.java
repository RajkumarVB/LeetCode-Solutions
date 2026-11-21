/*
 * 37. Sudoku Solver  [Hard]
 * https://leetcode.com/problems/sudoku-solver/
 * Topics: Array, Hash Table, Backtracking, Matrix, Algorithm X, Dancing Links
 *
 * Problem:     Fill a 9x9 Sudoku board in place (exactly one solution exists).
 * Example:     partially filled board -> solved board
 * Constraints: 9 x 9
 *
 * Key idea:    Backtracking: find the next empty cell, try 1-9 if valid in its row, column
 *              and 3x3 box, recurse, and undo on failure. Box cell for i in 0..8: (3*(r/3)
 *              + i/3, 3*(c/3) + i%3).
 *
 * Approach:    Backtracking with row/col/box validity check
 * Complexity:  time O(9^empty), space O(81)
 * Submitted:   2025-08-31 (submission 1754788910, AC)
 */

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