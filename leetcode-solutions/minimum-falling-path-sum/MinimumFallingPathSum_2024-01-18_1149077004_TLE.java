class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; 
        int ans = Integer.MAX_VALUE; 
        int[][] dp = new int[n][n];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        for(int j=0; j<n; j++){
            ans = Math.min(ans, solve(n-1,j,matrix,dp)); 
        }
        return ans; 

    }
    public int solve(int i, int j,int[][] matrix,int[][] dp){
        int n = matrix.length; 
        if(j <0 || j >=n ) return (int) Math.pow(10,9); 
        if(i ==0) return matrix[0][j];
        if(dp[i][j] != -1) return dp[i][j];
        int up, left, right; 
        up = matrix[i][j] + solve(i-1,j, matrix,dp);
        left = matrix[i][j] + solve(i-1,j-1,matrix,dp);
        right = matrix[i][j] + solve(i-1,j+1, matrix,dp);

        return dp[i][j] = Math.min(Math.min(up,left),right); 
    }
}