class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; 
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return findWays(m-1,n-1,dp); 
    }
    public int findWays(int i, int j, int[][] dp){
        if(i < 0 || j < 0) return 0; 
        if(i ==0 && j ==0) return 1;
        if(dp[i][j] != -1) return dp[i][j]; 
        int up = findWays(i-1,j,dp); 
        int left = findWays(i,j-1,dp); 
        return dp[i][j] = up + left; 
    }
}