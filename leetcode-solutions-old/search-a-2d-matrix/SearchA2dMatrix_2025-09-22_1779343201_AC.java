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