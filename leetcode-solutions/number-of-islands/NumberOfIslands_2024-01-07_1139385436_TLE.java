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
                    bfs(i,j);
                }
            }
        }
        return count; 
    }

    public void bfs(int x, int y){
        Deque<Pair<Integer,Integer>> queue = new LinkedList<>();
        visited[x][y] = true; 
        queue.addLast(new Pair(x,y));

        while(!queue.isEmpty()){
            Pair<Integer,Integer> p = queue.removeFirst();
            int i = p.getKey();
            int j = p.getValue();

            visited[i][j] = true; 

            if(i-1 >=0 && grid[i-1][j] == '1' && visited[i-1][j] == false){
                queue.addLast(new Pair(i-1,j));
            }

            if(i+1 <row && grid[i+1][j] == '1' && visited[i+1][j] == false){
                queue.addLast(new Pair(i+1,j));
            }

            if(j-1 >=0 && grid[i][j-1] == '1' && visited[i][j-1] == false){
                queue.addLast(new Pair(i,j-1));
            }

            if(j+1 < col && grid[i][j+1] == '1' && visited[i][j+1] == false){
                queue.addLast(new Pair(i,j+1));
            }
        }
    }

}