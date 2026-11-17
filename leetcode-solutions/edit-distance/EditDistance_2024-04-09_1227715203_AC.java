class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1); 
        }

        return minDistance(m,n,word1,word2,dp);
    }
    public int minDistance(int i, int j, String s1, String s2, int[][] dp){
        if(i == 0) return j;
        if(j == 0) return i; 
        if(dp[i][j] != -1) return dp[i][j]; 
        
        if(s1.charAt(i-1) == s2.charAt(j-1)) return dp[i][j] = minDistance(i-1,j-1,s1,s2,dp); 
        int insert = 1 + minDistance(i,j-1,s1,s2,dp);
        int delete = 1 + minDistance(i-1,j,s1,s2,dp);
        int replace = 1 + minDistance(i-1,j-1,s1,s2,dp); 
        return dp[i][j] = Math.min(Math.min(insert,delete),replace); 
    }
}