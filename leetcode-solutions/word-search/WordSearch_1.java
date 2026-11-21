/*
 * 79. Word Search  [Medium]
 * https://leetcode.com/problems/word-search/
 * Topics: Array, String, Backtracking, Depth-First Search, Matrix
 *
 * Problem:     Can word be traced in the grid through adjacent cells without reusing a
 *              cell?
 * Example:     board ABCE/SFCS/ADEE, "ABCCED" -> true
 * Constraints: up to 6 x 6, word <= 15
 *
 * Key idea:    DFS backtracking from each matching start cell. Mark the cell as used (e.g.
 *              temporarily change it), recurse in 4 directions, then restore it.
 *
 * Approach:    DFS, mark by mutating the board
 * Complexity:  time O(m*n*4^L), space O(L)
 * Also see:    _2: DFS with a HashSet of used cells
 * Submitted:   2024-03-16 (submission 1205251498, AC)
 */

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