/*
 * 417. Pacific Atlantic Water Flow  [Medium]
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * Topics: Array, Depth-First Search, Breadth-First Search, Matrix
 *
 * Problem:     Water flows to neighbours of equal or lower height. Return the cells from
 *              which water can reach both the Pacific (top and left edges) and the Atlantic
 *              (bottom and right edges).
 * Example:     5x5 heights grid -> 7 cells
 * Constraints: up to 200 x 200
 *
 * Key idea:    Reverse the flow: DFS uphill from every Pacific border cell and from every
 *              Atlantic border cell, marking what each ocean can reach. Return the cells
 *              marked by both.
 *
 * Approach:    Reverse DFS from both ocean borders
 * Complexity:  time O(m*n), space O(m*n)
 * Submitted:   2026-01-02 (submission 1872257443, AC)
 */

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