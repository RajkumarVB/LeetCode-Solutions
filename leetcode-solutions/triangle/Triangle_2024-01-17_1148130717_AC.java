class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int dp[][] = new int[m][m];
        
        for(int j=0; j<m; j++){
            dp[m-1][j] = triangle.get(m-1).get(j); 
        }
        for(int i=m-2; i>=0 ; i--){
            for(int j=0; j<=i; j++){
                int path1 = triangle.get(i).get(j) + dp[i+1][j];
                int path2 = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(path1, path2); 
            }
        }

        return dp[0][0]; 
    }
}