class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int dp[][] = new int[m][m];
        for(int [] arr : dp){
            Arrays.fill(arr,-1); 
        }
        return solve(0,0,m,triangle,dp); 
    }
    public int solve(int i, int j, int m,List<List<Integer>> triangle, int[][] dp){
        if(i == m-1){
            return triangle.get(i).get(j); 
        }
        if(dp[i][j] != -1) return dp[i][j];
        int path1 = triangle.get(i).get(j) + solve(i+1,j,m,triangle,dp);
        int path2 = triangle.get(i).get(j) + solve(i+1,j+1,m,triangle,dp);
        return dp[i][j] = Math.min(path1, path2); 
    }
}