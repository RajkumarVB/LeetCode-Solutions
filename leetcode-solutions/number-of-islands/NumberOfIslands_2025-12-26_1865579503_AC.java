class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 

        boolean[][] visited = new boolean[m][n]; 
        int noOfIslands = 0; 
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    dfs(i,j,grid, visited); 
                    noOfIslands++; 
                }
            }
        }
        return noOfIslands; 
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited){
        int m = grid.length; 
        int n = grid[0].length;


        if(i < 0 || i >=m || j<0 || j>=n || grid[i][j] == '0' || visited[i][j] == true) return; 

        visited[i][j] = true; 
        dfs(i+1,j, grid, visited);
        dfs(i,j+1, grid, visited);
        dfs(i-1,j, grid, visited);
        dfs(i,j-1, grid, visited);
    }
}