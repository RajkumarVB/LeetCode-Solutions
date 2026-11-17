class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] rowZeroes = new int[rows];
        int[] colZeroes = new int[cols];

        Arrays.fill(rowZeroes, -1);
        Arrays.fill(colZeroes,-1);


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j] ==0){
                    rowZeroes[i] = 0;
                    colZeroes[j] = 0;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(rowZeroes[i] ==0 || colZeroes[j] ==0){
                    matrix[i][j] = 0;
                    matrix[i][j] = 0;
                }
            }
        }
    }
}