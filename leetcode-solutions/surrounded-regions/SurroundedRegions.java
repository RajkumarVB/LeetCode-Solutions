/*
 * 130. Surrounded Regions  [Medium]
 * https://leetcode.com/problems/surrounded-regions/
 * Topics: Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
 *
 * Problem:     Flip every 'O' region that is fully surrounded by 'X' (doesn't touch the
 *              border) to 'X'.
 * Example:     inner O's become X; O's connected to the border stay
 * Constraints: up to 200 x 200
 *
 * Key idea:    Reverse thinking: DFS from every border 'O' and mark it safe. Afterwards,
 *              unmarked 'O's are captured (become X) and marked cells go back to 'O'.
 *
 * Approach:    DFS from border O's, then flip the rest
 * Complexity:  time O(m*n), space O(m*n)
 * Submitted:   2024-03-20 (submission 1208454351, AC)
 */

class Solution {
    public void solve(char[][] board) {
        int m = board.length; 
        int n = board[0].length; 
        for(int j=0; j<n; j++){
            dfs(0,j,m,n,board);
            dfs(m-1,j,m,n,board);
        }
        for(int i=0; i<m; i++){
            dfs(i,0,m,n,board);
            dfs(i,n-1,m,n,board);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'V'){
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(int i, int j, int m, int n, char[][]board){
        if(i<0 || j<0 || i>=m || j>=n || board[i][j] != 'O') return; 
        board[i][j] = 'V'; 
        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] del : dir){
            dfs(i+del[0], j+del[1], m, n, board); 
        }
    }
}