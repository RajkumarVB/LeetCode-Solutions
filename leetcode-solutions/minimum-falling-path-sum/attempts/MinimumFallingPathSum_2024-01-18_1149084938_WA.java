class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; 
        int[] curr = new int[n];
        int[] prev = new int[n];

        for(int j=0; j<n; j++){
            prev[j] = matrix[0][j]; 
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                int up, left, right; 
                up = left = right = Integer.MAX_VALUE; 
                if(i >= 1) up = matrix[i][j] + prev[j];
                if(i>= 1 && j>=1) left = matrix[i][j] + prev[j-1];
                if(i>= 1 && j<=n-2) right = matrix[i][j] + prev[j+1];
                curr[j] = Math.min(Math.min(up,left),right);
            }
            prev = curr; 
        }
        int ans = Integer.MAX_VALUE; 
        for(int j=0; j<n; j++){
            ans = Math.min(prev[j], ans);
        }
        return ans; 
    }
}