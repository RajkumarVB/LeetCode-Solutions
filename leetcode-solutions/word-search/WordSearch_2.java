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
 * Approach:    DFS with a HashSet of used cells
 * Complexity:  time O(m*n*4^L), space O(L)
 * Also see:    _1: DFS, mark by mutating the board
 * Submitted:   2026-01-21 (submission 1892235427, AC)
 */

class Solution {
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0) == board[i][j]){
                    if(isWordPresent(board, word, 0, i, j, new HashSet<>())){
                        return true; 
                    }
                }
            }
        }
        return false; 
    }

    private boolean isWordPresent(char[][] board, String word ,int wordIdx, int i, int j, HashSet<Point> usedLocations){
        int m = board.length, n = board[0].length; 
        Point currentPoint = new Point(i, j);
        if(i <0 || i>=m || j<0 || j>=n || board[i][j] != word.charAt(wordIdx) || usedLocations.contains(currentPoint)){
            return false; 
        }

        if(wordIdx == word.length() -1){
            return true; 
        }
        usedLocations.add(currentPoint);
        boolean matched =  isWordPresent(board, word, wordIdx + 1, i+1,j,usedLocations) || isWordPresent(board, word, wordIdx + 1, i-1,j,usedLocations)
                                || isWordPresent(board, word, wordIdx + 1, i,j-1,usedLocations) || isWordPresent(board, word, wordIdx + 1, i,j+1,usedLocations);

        usedLocations.remove(currentPoint);
        return matched;
    }

    record Point(int i, int j){};
}