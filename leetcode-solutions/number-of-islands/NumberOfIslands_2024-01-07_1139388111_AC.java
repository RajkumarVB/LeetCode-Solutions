class Solution {
    private boolean[][] visited; 
    private int row; 
    private int col; 
    private char[][] grid; 
    public int numIslands(char[][] grid) {
        this.row = grid.length; 
        this.col = grid[0].length; 
        this.visited = new boolean[row][col];
        this.grid = grid; 


        int count = 0; 
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count ++; 
                    dfs(i,j);
                }
            }
        }
        return count; 
    }

    public void dfs(int x, int y){
       if(x<0 || x>=row || y<0 || y>=col || visited[x][y] == true || grid[x][y] == '0') return; 
       visited[x][y] = true; 
       dfs(x-1,y);
       dfs(x+1,y);
       dfs(x,y+1);
       dfs(x,y-1);
    }

}