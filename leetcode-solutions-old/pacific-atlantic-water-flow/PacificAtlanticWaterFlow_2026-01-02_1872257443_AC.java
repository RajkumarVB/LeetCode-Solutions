class Solution {

    private int[][] directions = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}}; 

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length; 
        int n = heights[0].length; 

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(boolean[] arr : pacific){
            Arrays.fill(arr, false);
        }
        for(boolean[] arr : atlantic){
            Arrays.fill(arr, false);
        }

        for(int i=0; i<m; i++){
            // first column 
            dfs(i, 0, pacific, heights, -1);

            // last column
            dfs(i, n-1, atlantic, heights, -1);
        }

        
        for(int j=0; j<n; j++){
            // first row 
            dfs(0, j, pacific, heights, -1);

            // last row
            dfs( m-1, j, atlantic, heights, -1);
        }

        List<List<Integer>> result = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }
        return result; 
    }


    public void dfs(int i, int j, boolean[][] visited, int[][] heights, int prevHeight){
        int m = heights.length; 
        int n = heights[0].length; 

        if(i < 0 || i >= m || j <0 || j>=n || visited[i][j] == true || heights[i][j] < prevHeight) return; 
        visited[i][j] = true; 
        for(int[] dir : directions){
            int delX = dir[0];
            int delY = dir[1];
            dfs(i+delX, j+delY, visited, heights, heights[i][j]);
        }

    }
}