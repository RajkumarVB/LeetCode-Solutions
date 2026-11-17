class Solution {
    int[][] grid;
    boolean[][] visited; 
    int m, n; 
    public int maxAreaOfIsland(int[][] grid) {
        this.m = grid.length; 
        this.n = grid[0].length; 
        this.visited = new boolean[m][n]; 
        this.grid = grid; 
        for(boolean[] row : visited){
            Arrays.fill(row,false); 
        }
        int maxArea = 0; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int area = dfs(i,j); 
                    maxArea= Math.max(maxArea, area); 
                }
            }
        }
        return maxArea; 
    }
    public int dfs(int i, int j){
        if(i <0 || j<0 || i>=m || j>=n || visited[i][j] || grid[i][j] == 0) return 0; 
        visited[i][j] = true; 
        return 1 + dfs(i-1,j) + dfs(i+1,j) + dfs(i,j+1) + dfs(i,j-1);
    }
}