class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    return bfs(i, j, visited, grid);
                }
            }
        }
        return 0; 
    
    }

    private int bfs(int i, int j, boolean[][] visited, int[][] grid){
        int m = grid.length; 
        int n = grid[0].length;
        visited[i][j] = true; 
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        int totalPerimeter = 0; 
        int[][] directions = new int[][]{{-1,0}, {1, 0}, {0,-1}, {0,1}};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int currI = p.i; 
            int currJ = p.j;

            
            if(currI - 1 <0 || grid[currI-1][currJ] == 0){
                totalPerimeter +=1; 
            }
            if(currI + 1 >= m || grid[currI+1][currJ] == 0){
                totalPerimeter +=1; 
            }
            if(currJ - 1 <0 || grid[currI][currJ-1] == 0){
                totalPerimeter +=1; 
            }
            if(currJ + 1 >= n || grid[currI][currJ+1] == 0){
                totalPerimeter +=1; 
            }

            

            for(int[] dir : directions){
                int newI = dir[0] + currI; 
                int newJ = dir[1] + currJ; 

                if(newI <0 || newI >=m || newJ<0 || newJ >=n || grid[newI][newJ] == 0|| visited[newI][newJ] == true){
                    continue; 
                }
                q.offer(new Pair(newI, newJ));
                visited[currI][currJ] = true; 
            }
        }
        return totalPerimeter;
    }

    record Pair(int i, int j){}
}