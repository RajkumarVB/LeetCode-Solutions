class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length; 
        int cols = grid[0].length; 

        Queue<Orange> q = new LinkedList<>();
        int freshOrangeCount = 0; 

        boolean[][] visited = new boolean[rows][cols]; 
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    freshOrangeCount ++; 
                }else if(grid[i][j] == 2){
                    q.offer(new Orange(i, j, 0)); 
                    visited[i][j] = true; 
                }
            }
        }

        int maxTime = 0;
        int noOfNewlyRottenedOranges = 0; 

        while(!q.isEmpty()){
            Orange orange = q.poll(); 
            maxTime = Math.max(maxTime, orange.time);

            int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}}; 
            for(int[] dir : directions){
                int newX = orange.x + dir[0]; 
                int newY = orange.y + dir[1];
                int newTime = orange.time + 1;  
                if(newX >=0 && newX <rows && newY >=0 && newY <cols && 
                    grid[newX][newY] == 1 && visited[newX][newY] == false){
                        q.offer(new Orange(newX, newY, newTime)); 
                        visited[newX][newY] = true; 
                        noOfNewlyRottenedOranges ++; 
                    }
            }
        }
        if(freshOrangeCount != noOfNewlyRottenedOranges) return -1; 
        return maxTime; 
    }

    class Orange{
        int x; 
        int y; 
        int time; 
        public Orange(int x, int y, int time){
            this.x = x; 
            this.y = y; 
            this.time = time; 
        }
    }
}