class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int freshOranges = 0;
        int rottened = 0;
        boolean[][] visited = new boolean[m][n];
        Deque<Pair> queue = new LinkedList<>();

        int resultTime = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    // This is a rotten orange
                    queue.addLast(new Pair(i,j,0));
                } else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        // BFS
        while(!queue.isEmpty()){
            Pair orange = queue.removeLast();
            int i = orange.x;
            int j = orange.y;
            int t = orange.time;

            resultTime = Math.max(resultTime, t);

            int[] drow = {-1,0,1,0};
            int[] dcol = {0,-1,0,1};

            for(int k=0; k<4; k++){
                int tempi = i + drow[k];
                int tempj = j + dcol[k];

                if(tempi >=0 && tempi <m && tempj>=0
                        && tempj<n &&
                        grid[tempi][tempj] == 1 &&
                        !visited[tempi][tempj]){
                    visited[tempi][tempj] = true;
                    queue.addLast(new Pair(tempi, tempj, t+1));
                    rottened ++;
                }
            }
        }
        if(rottened != freshOranges) return -1;
        return resultTime;
    }
}

class Pair{
    int x; 
    int y; 
    int time; 

    public Pair(int x, int y, int time){
        this.x = x; 
        this.y = y; 
        this.time = time; 
    }
}