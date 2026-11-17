class Solution {
    int m, n; 
    int[][] heights; 
    int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}}; 
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length; 
        n = heights[0].length; 
        this.heights = heights; 
        boolean[][] pacificOceanCells = new boolean[m][n]; 
        boolean[][] atlanticOceanCells = new boolean[m][n]; 
        List<List<Integer>> result = new LinkedList<>(); 
        for(int j=0; j<n; j++){
            // First and last Row
            dfs(0,j,pacificOceanCells, heights[0][j]);
            dfs(m-1,j,atlanticOceanCells, heights[m-1][j]);
        }
        for(int i=0; i<m; i++){
            // First and last column
            dfs(i,0,pacificOceanCells,heights[i][0]);
            dfs(i,n-1,atlanticOceanCells,heights[i][n-1]);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacificOceanCells[i][j] && atlanticOceanCells[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
        return result; 
    }
    public void dfs(int i, int j, boolean[][] visited, int prevHeight){
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || prevHeight > heights[i][j] ) return; 
        visited[i][j] = true; 
        for(int[] del : dir){
            dfs(i+del[0],j+del[1],visited,heights[i][j]);
        }
    }
    record Point(int i, int j){

    }
}

