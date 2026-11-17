class Solution {
    int m, n; 
    int[][] heights; 
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length; 
        n = heights[0].length; 
        this.heights = heights; 
        HashSet<Point> pacificOceanCells = new HashSet<>();
        HashSet<Point> atlanticOceanCells = new HashSet<>();
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
        for(Point p : pacificOceanCells){
            if(atlanticOceanCells.contains(p)){
                List<Integer> tempResult = new LinkedList<>();
                tempResult.add(p.i);
                tempResult.add(p.j);
                result.add(tempResult);
            }
        }
        return result; 
    }
    public void dfs(int i, int j, HashSet<Point> visited, int prevHeight){
        if(i<0 || j<0 || i>=m || j>=n || visited.contains(new Point(i,j)) || prevHeight > heights[i][j] ) return; 
        visited.add(new Point(i,j));
        dfs(i-1,j,visited,heights[i][j]);
        dfs(i+1,j,visited,heights[i][j]);
        dfs(i,j+1,visited,heights[i][j]);
        dfs(i,j-1,visited,heights[i][j]);
    }
    record Point(int i, int j){

    }
}