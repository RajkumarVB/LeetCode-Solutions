class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; 
        int[][] dp = new int[n][n];
        for(int j=0; j<n; j++){
            dp[0][j] = matrix[0][j]; 
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                int up, left, right; 
                up = left = right = Integer.MAX_VALUE; 
                if(i >= 1) up = matrix[i][j] + dp[i-1][j];
                if(i>= 1 && j>=1) left = matrix[i][j] + dp[i-1][j-1];
                if(i>= 1 && j<=n-2) right = matrix[i][j] + dp[i-1][j+1];
                dp[i][j] = Math.min(Math.min(up,left),right);
            }
        }
        int ans = Integer.MAX_VALUE; 
        for(int j=0; j<n; j++){
            ans = Math.min(dp[n-1][j], ans);
        }
        return ans; 
    }
}