/*
 * 36. Valid Sudoku  [Medium]
 * https://leetcode.com/problems/valid-sudoku/
 * Topics: Array, Hash Table, Matrix
 *
 * Problem:     Check whether the filled cells of a 9x9 board break any Sudoku rule (rows,
 *              columns, 3x3 boxes).
 * Example:     standard board -> true or false
 * Constraints: 9 x 9
 *
 * Key idea:    Nine HashSets each for rows, columns and boxes. The box index is (r/3)*3 +
 *              c/3. A repeated digit in any set means invalid.
 *
 * Approach:    Row/col/box sets with box index (r/3)*3+c/3
 * Complexity:  time O(81), space O(81)
 * Submitted:   2025-09-11 (submission 1767332980, AC)
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> rows = new ArrayList<>(9);
        List<HashSet<Character>> cols = new ArrayList<>(9);
        List<HashSet<Character>> boxes = new ArrayList<>(9);

        for(int i=0; i<9; i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }
        
        int boardSize = board.length; 
        for(int i=0; i<boardSize; i++){
            for(int j=0; j<boardSize; j++){
                if(board[i][j] == '.') continue; 
                char currentChar = board[i][j]; 

                if(rows.get(i).contains(currentChar)) return false; 
                if(cols.get(j).contains(currentChar)) return false; 
                int boxNo = ((i / 3) * 3) + (j / 3); 

                if(boxes.get(boxNo).contains(currentChar)) return false; 

                rows.get(i).add(currentChar);
                cols.get(j).add(currentChar); 
                boxes.get(boxNo).add(currentChar); 

            }
        }
        return true; 
    }
}

// boxNo = ((row / 3) * 3) + (col / 3)

