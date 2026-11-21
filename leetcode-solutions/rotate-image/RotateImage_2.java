/*
 * 48. Rotate Image  [Medium]
 * https://leetcode.com/problems/rotate-image/
 * Topics: Array, Math, Matrix
 *
 * Problem:     Rotate an n x n matrix 90 degrees clockwise, in place.
 * Example:     [[1,2,3],[4,5,6],[7,8,9]] -> [[7,4,1],[8,5,2],[9,6,3]]
 * Constraints: n <= 20
 *
 * Key idea:    Clockwise rotation = transpose (swap m[i][j] with m[j][i] for j > i), then
 *              reverse each row.
 *
 * Approach:    Copy into a new matrix (not in place)
 * Complexity:  time O(n^2), space O(n^2)
 * Also see:    _1: Transpose + reverse rows
 * Submitted:   2023-08-28 (submission 1033467172, AC)
 */

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length; 
        int[][] result = new int[n][m];
        for(int i =0 ; i<n ;i++){
            for(int j =0 ; j<m; j++){
                result[j][n-1-i] = matrix[i][j];
            }
        }
        for(int i =0 ; i<n ;i++){
            for(int j =0 ; j<m; j++){
                matrix[i][j] = result[i][j]; 
            }
        }
    }
}