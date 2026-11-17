class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length; 
        int n = grid[0].length; 
        
        boolean[][] visited = new boolean[m][n]; 
        int maxArea = 0; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && (visited[i][j] == false)){
                    System.out.println("Inside");
                    int area = bfs(i, j, grid, visited); 
                    System.out.println("Area = " + area); 
                    maxArea = Math.max(area, maxArea); 
                }        
            }
        }
        return maxArea; 
        
    }

    record Pair(int i, int j){
    }

    
    private int bfs(int i, int j, int[][] grid, boolean[][] visited){
        int m = grid.length; 
        int n = grid[0].length; 

        LinkedList<Pair> q = new LinkedList<>(); 
        q.addLast(new Pair(i, j)); 
        visited[i][j] = true; 

        int area = 0; 

        while(!q.isEmpty()){
            Pair p = q.removeFirst();
            int x = p.i; 
            int y = p.j; 
            area ++; 

            int[][] directions = new int[][] {{0,-1}, {0,1}, {1,0}, {-1, 0}}; 
            for(int[] dir : directions ){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >=0 && newX <m && newY >=0 && newY <n && visited[newX][newY] == false && grid[newX][newY] == 1){
                    q.addLast(new Pair(newX, newY)); 
                    visited[newX][newY] = true; 
                    
                }
            }
        }
        return area; 
    }
}

