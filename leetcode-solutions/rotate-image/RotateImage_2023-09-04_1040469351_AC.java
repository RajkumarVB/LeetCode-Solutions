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