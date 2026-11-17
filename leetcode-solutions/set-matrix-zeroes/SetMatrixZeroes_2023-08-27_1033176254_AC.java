class Solution {
    public void setZeroes(int[][] matrix) {
        int rowSize = matrix.length; 
        int colSize = matrix[0].length; 
        int[] row = new int[rowSize];
        int[] col = new int[colSize];
        for(int i=0 ;i<rowSize; i++){
            for(int j=0; j<colSize; j++){
                if(matrix[i][j] ==0){
                    row[i] =1;
                    col[j] =1;
                }
            }
        }
        // printArray(row);
        // printArray(col);
        for(int i=0 ;i<rowSize; i++){
            for(int j=0; j<colSize; j++){
                if(row[i] ==1 || col[j] ==1) matrix[i][j] =0; 
            }
        }
    }
    public static void printArray(int[] arr){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i]+ " "); 
        }
        System.out.println();
    }
}