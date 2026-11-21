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
 * Approach:    Transpose + reverse rows
 * Complexity:  time O(n^2), space O(1)
 * Also see:    _2: Copy into a new matrix (not in place)
 * Submitted:   2023-09-04 (submission 1040469351, AC)
 */

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        transpose(matrix);
        for(int i=0;i<n;i++){
            reverse(matrix[i]);
        }
    }
    public static void transpose(int[][] matrix){
        int n = matrix.length; 
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }
    }
    public static void reverse(int[] arr){
        int n = arr.length; 
        int i=0, j=n-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp; 

            i++;
            j--;
        }
    }
}