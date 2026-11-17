class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 

        boolean[][] visited = new boolean[m][n];
        int maxArea = 0; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    int area = computeIslandArea(grid, i, j, visited);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea; 
    }

    private int computeIslandArea(int[][] grid, int i, int j, boolean[][] visited){
        int m = grid.length; 
        int n = grid[0].length; 
        if(i <0 || i>=m || j<0 || j>=n || visited[i][j] == true || grid[i][j] == 0){
            return 0; 
        } 
        visited[i][j] = true; 

        int[][] directions = new int[][] {{-1,0}, {1,0}, {0,1}, {0,-1}};
        int area = 0; 
        for(int[] dir : directions){
            int newX = i + dir[0];
            int newY = j + dir[1];
            area += computeIslandArea(grid, newX, newY, visited);
        }
        return 1 + area; 

    }

    
}