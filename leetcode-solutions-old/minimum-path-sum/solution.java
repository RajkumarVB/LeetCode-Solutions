class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        int[][] dp = new int[m][n]; 

        int[] curr = new int[n];
        int[] prev = new int[n];
        
        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j ==0) curr[j] = grid[0][0]; 
                else{
                    int up, left; 
                    up = (i>0) ? prev[j] : Integer.MAX_VALUE;
                    left = (j>0)? curr[j-1] : Integer.MAX_VALUE;  
                    curr[j] = grid[i][j] + Math.min(up,left); 
                }
            }
            prev = curr; 
        }
        return prev[n-1]; 
    }
}