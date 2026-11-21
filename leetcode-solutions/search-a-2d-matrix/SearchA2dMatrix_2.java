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
 * Approach:    Binary search each row
 * Complexity:  time O(m log n), space O(1)
 * Also see:    _1: One binary search over flattened indices
 * Submitted:   2024-01-29 (submission 1160117291, AC)
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; 
        int n = matrix[0].length; 
        for(int i=0; i<m; i++){
            if(bs(matrix[i], target)) return true; 
        }
        return false; 
    }
    public boolean bs(int[] arr, int target){
        int n = arr.length; 
        int low =0, high = n-1;
        while(low <= high){
            int mid = (low+high)/2; 
            if(arr[mid] == target) return true; 
            else if(arr[mid] > target){
                high = mid -1; 
            } else {
                low = mid +1; 
            }
        }
        return false; 
    }
}