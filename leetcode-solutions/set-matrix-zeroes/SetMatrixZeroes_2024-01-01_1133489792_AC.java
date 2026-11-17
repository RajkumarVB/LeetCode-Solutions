class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length; 
        int cols = matrix[0].length; 
        

        boolean col0 = false; 
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] ==0){
                    matrix[i][0] = 0; 

                    if(j ==0) col0 = true; 
                    else matrix[0][j] = 0; 
                }
            }
        }
        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if(matrix[i][0] == 0 || matrix[0][j] ==0 ) matrix[i][j] =0; 
            }
        }
        // Modifying 1st row first, since 1st column depends on value of matrix[0][0]
        for(int j=1; j<cols; j++){
            if(matrix[0][0] == 0){
                matrix[0][j] = 0; 
            }
        }
        for(int i=0; i<rows; i++){
            if(col0 == true){
                matrix[i][0] = 0; 
            }
        }
    }
}