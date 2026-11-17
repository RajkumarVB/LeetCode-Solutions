class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for(int [] arr : cache){
            Arrays.fill(arr, -1);
        }

        return findTotalPaths(m-1, n-1, cache);
    }

    private int findTotalPaths(int i, int j, int[][] cache){
        if(i == 0 && j ==0){
            return 1; 
        }
        if(i < 0 || j < 0) return 0 ; 
        if(cache[i][j] != -1) return cache[i][j];
        int totalPaths = findTotalPaths(i-1, j, cache) + findTotalPaths(i, j-1, cache) ;
        return cache[i][j] = totalPaths;
    }
}