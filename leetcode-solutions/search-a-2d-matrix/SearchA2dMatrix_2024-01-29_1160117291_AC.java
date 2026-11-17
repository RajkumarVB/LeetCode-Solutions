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