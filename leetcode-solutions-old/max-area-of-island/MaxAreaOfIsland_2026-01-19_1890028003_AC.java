class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 

        boolean[][] visited = new boolean[m][n];
        int maxArea = 0; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    int area = bfs(grid, i, j, visited);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea; 
    }

    record Point(int i , int j){

    }

    private int bfs(int[][] grid, int i, int j, boolean[][] visited){
        int m= grid.length;
        int n= grid[0].length; 

        LinkedList<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        visited[i][j] = true; 

        int[][] directions = new int[][] {{-1,0}, {0,1}, {0,-1}, {1,0}};
        int area = 0; 
        while(!q.isEmpty()){
            Point p = q.removeFirst();
            area += 1; 
            for(int[] dir : directions){
                int newX = p.i + dir[0];
                int newY = p.j + dir[1];

                if(newX < m && newX >=0 && newY >=0 && newY <n && visited[newX][newY] == false && grid[newX][newY] == 1){
                    q.addLast(new Point(newX, newY));
                    visited[newX][newY] = true; 
                }
            }
        }
        return area; 
    }
}