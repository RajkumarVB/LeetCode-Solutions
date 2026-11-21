/*
 * 73. Set Matrix Zeroes  [Medium]
 * https://leetcode.com/problems/set-matrix-zeroes/
 * Topics: Array, Hash Table, Matrix
 *
 * Problem:     If a cell is 0, set its whole row and column to 0, in place.
 * Example:     [[1,1,1],[1,0,1],[1,1,1]] -> [[1,0,1],[0,0,0],[1,0,1]]
 * Constraints: up to 200 x 200
 *
 * Key idea:    O(m+n) space: separate row and column flag arrays. O(1) space: use the first
 *              row and first column as the flags, plus one extra variable for column 0, and
 *              fill them in last.
 *
 * Approach:    Row and column marker arrays
 * Complexity:  time O(m*n), space O(m + n)
 * Also see:    _1: First row/column as markers + col0 flag
 * Submitted:   2024-01-01 (submission 1133478301, AC)
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length; 
        int cols = matrix[0].length; 

        int[] rowZeroes = new int[rows];
        int[] colZeroes = new int[cols]; 

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] ==0){
                    rowZeroes[i] = 1;
                    colZeroes[j] = 1; 
                }
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(rowZeroes[i] ==1 || colZeroes[j] == 1){
                    matrix[i][j] = 0; 
                }
            }
        }
    }
}