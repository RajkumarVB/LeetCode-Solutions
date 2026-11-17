class Solution {
    char[][] grid;
    int m;
    int n; 
    boolean[][]visited; 

    public int numIslands(char[][] grid) {
        this.m = grid.length; 
        this.n = grid[0].length; 
        this.visited = new boolean[m][n];
        this.grid = grid;
        for(boolean[] row : visited){
            Arrays.fill(row,false); 
        }
        int islands =0; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i,j);
                    islands++;
                }
            }
        }
        return islands; 
    }
    public void dfs(int i, int j){
        if(i <0 || j<0 || i >= m || j >= n||visited[i][j] || grid[i][j] == '0') return; 
        visited[i][j] = true;
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);
    }
}