class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length; 
        // Transpose 
        for(int i =0; i<n-1; i++){
            for(int j =i+1; j<n; j++){
                // Swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }

        // Reversing each row 
        for(int i =0; i<n; i++){
            reverse(matrix[i]);
        }
    }
    public static void reverse(int[] arr){
        int n = arr.length; 
        int i =0 , j = n-1; 
        while(i <j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    public static void swap(int[]arr, int i , int j){
        int temp; 
        temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp ;
    }
}