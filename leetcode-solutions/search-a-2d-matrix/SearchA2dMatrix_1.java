/*
 * 74. Search a 2D Matrix  [Medium]
 * https://leetcode.com/problems/search-a-2d-matrix/
 * Topics: Array, Binary Search, Matrix
 *
 * Problem:     Search a matrix whose rows are sorted and each row starts after the previous
 *              row ends. Must be O(log(m*n)).
 * Example:     [[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3 -> true
 * Constraints: up to 100 x 100
 *
 * Key idea:    Treat it as one sorted array of length m*n: index k maps to row k / cols and
 *              column k % cols. Run a single binary search.
 *
 * Approach:    One binary search over flattened indices
 * Complexity:  time O(log(m*n)), space O(1)
 * Also see:    _2: Binary search each row
 * Submitted:   2025-09-22 (submission 1779343201, AC)
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length; 
        int cols = matrix[0].length; 
        int noOfElements = rows*cols; 
        int left = 0, right = noOfElements -1; 
        while(left <= right){
            int mid = (right - left) / 2 + left; 
            int row = mid / cols; 
            int col = mid % cols; 

            if(matrix[row][col] == target) return true; 
            if(matrix[row][col] > target){
                right = mid -1; 
            }else{
                left = mid + 1; 
            }
        }
        return false; 
    }
}