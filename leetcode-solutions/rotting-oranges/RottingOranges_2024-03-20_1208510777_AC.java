class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        int freshOranges = 0; 
        int resultTime = 0; 
        Queue<Position> q = new LinkedList<>(); 
        boolean[][] visited = new boolean[m][n]; 

        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    visited[i][j] = true;
                    q.offer(new Position(i,j,0)); 
                } else if(grid[i][j] == 1){
                    freshOranges++; 
                }
            }
        }
        int rottenedOranges = 0; 
        while(!q.isEmpty()){
            Position pos = q.poll();
            int x = pos.x, y = pos.y, time = pos.time; 
            resultTime = Math.max(resultTime, time);
            int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
            for(int[] del : dir){
                int neiX = x + del[0], neiY = y + del[1]; 
                if(neiX >= 0 && neiX <m && neiY >=0 
                    && neiY <n && !visited[neiX][neiY] && 
                    grid[neiX][neiY] == 1){
                        rottenedOranges++; 
                        visited[neiX][neiY] = true; 
                        q.offer(new Position(neiX,neiY,time+1)); 
                    }
            }
        }
        if(freshOranges != rottenedOranges) return -1; 
        return resultTime; 

    }
    record Position(int x, int y, int time){

    }
}