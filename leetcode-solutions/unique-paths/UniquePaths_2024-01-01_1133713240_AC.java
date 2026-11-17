class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dpTable = new int[m][n]; 

        for(int j=0; j<n; j++){
            dpTable[m-1][j] = 1; 
        }
        for(int i=0; i<m; i++){
            dpTable[i][n-1] = 1; 
        }

        for(int i= m-2; i>=0; i--){
            for(int j=n-2;j>=0; j--){
                dpTable[i][j] = dpTable[i+1][j] + dpTable[i][j+1]; 
            }
        }
        return dpTable[0][0]; 
    }
}