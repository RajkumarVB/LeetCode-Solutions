class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.height - b.height); 
        int m = grid.length, n = grid[0].length; 
        boolean[][] visited = new boolean[m][n]; 
        for(boolean[] arr : visited){
            Arrays.fill(arr,false); 
        }

        pq.add(new Tuple(grid[0][0], 0, 0)); 
        visited[0][0] = true; 
        while(!pq.isEmpty()){
            Tuple t = pq.poll(); 
            int height = t.height; 
            int r = t.r; 
            int c = t.c; 

            if(r == m-1 && c == n-1) return height; 

            int[][] directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}}; 
            for(int[] dir : directions){
                int newR = r + dir[0];
                int newC = c + dir[1];

                if(newR >= 0 && newR < m && newC >= 0 && newC <n && !visited[newR][newC]){
                    int maxHeight = Math.max(height, grid[newR][newC]); 
                    pq.add(new Tuple(maxHeight, newR, newC)); 
                    visited[newR][newC] = true; 
                }
            }
        }
        return 1; // this will never execute 
    }

    record Tuple(int height, int r, int c){

    }
}