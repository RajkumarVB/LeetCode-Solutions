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
                    bfs(i,j);
                    islands++;
                }
            }
        }
        return islands; 
    }
    public void bfs(int i, int j){
        Queue<Pair> q = new LinkedList<>(); 
        q.offer(new Pair(i,j)); 
        while(!q.isEmpty()){
            Pair first = q.poll(); 
            int x = first.i; 
            int y = first.j; 
            if(x >=0 && y >=0 && x<m && y<n && !visited[x][y] && grid[x][y] == '1'){
                visited[x][y] = true; 
                q.offer(new Pair(x+1,y));
                q.offer(new Pair(x-1,y));
                q.offer(new Pair(x,y+1));
                q.offer(new Pair(x,y-1));
            }
        }
    }
    public record Pair(int i, int j){

    }
}