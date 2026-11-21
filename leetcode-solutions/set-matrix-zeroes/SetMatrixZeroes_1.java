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
 * Approach:    First row/column as markers + col0 flag
 * Complexity:  time O(m*n), space O(1)
 * Also see:    _2: Row and column marker arrays
 * Submitted:   2023-09-04 (submission 1040162619, AC)
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        // row -> matrix[0][..]
        // col -> matrix[..][0]
        int m = matrix.length; 
        int n = matrix[0].length; 
        int col0 = 1; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] ==0){
                    matrix[i][0] = 0 ; 
                    if(j==0){
                        col0= 0;
                    }else{
                        matrix[0][j] =0; 
                    }
                }
            }
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[0][j] ==0 || matrix[i][0] ==0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] ==0){
            for(int j=0;j<n;j++){
                matrix[0][j] =0; 
            }
        }
        if(col0 ==0){
            for(int i =0; i<m; i++){
                matrix[i][0] = 0; 
            }
        }
    }
}