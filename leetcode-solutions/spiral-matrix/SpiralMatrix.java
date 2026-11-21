/*
 * 54. Spiral Matrix  [Medium]
 * https://leetcode.com/problems/spiral-matrix/
 * Topics: Array, Matrix, Simulation
 *
 * Problem:     Return all elements of a matrix in clockwise spiral order.
 * Example:     [[1,2,3],[4,5,6],[7,8,9]] -> [1,2,3,6,9,8,7,4,5]
 * Constraints: up to 10 x 10
 *
 * Key idea:    Keep four boundaries (top, bottom, left, right). Traverse the top row, right
 *              column, bottom row and left column, shrinking a boundary after each. Re-
 *              check top <= bottom and left <= right before the 3rd and 4th legs.
 *
 * Approach:    Boundary shrinking simulation
 * Complexity:  time O(m*n), space O(1) extra
 * Submitted:   2025-05-04 (submission 1625196811, AC)
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length; 
        int m = matrix[0].length; 

        int top = 0, bottom = n -1, left =0, right = m-1; 
        List<Integer> ans = new LinkedList<>(); 
        while(top <= bottom && left <= right){
            
            for(int i=left; i<= right ;i++){
                ans.add(matrix[top][i]); 
            }
            top ++;

            for(int i=top; i<= bottom; i++){
                ans.add(matrix[i][right]); 
            }
            right --; 

            if(top <= bottom){
                for(int i=right; i>=left; i--){
                    ans.add(matrix[bottom][i]); 
                }
                bottom --; 
            }
            if(left <= right){
                for(int i=bottom; i>=top; i--){
                    ans.add(matrix[i][left]) ; 
                }
                left ++; 
            }
        }
        return ans; 
    }
}