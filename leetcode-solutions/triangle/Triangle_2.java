/*
 * 120. Triangle  [Medium]
 * https://leetcode.com/problems/triangle/
 * Topics: Array, Dynamic Programming
 *
 * Problem:     Return the minimum path sum from the top to the bottom of a triangle,
 *              stepping to index i or i+1 on the next row.
 * Example:     [[2],[3,4],[6,5,7],[4,1,8,3]] -> 11
 * Constraints: <= 200 rows
 *
 * Key idea:    Go bottom-up: dp[j] = tri[i][j] + min(dp[j], dp[j+1]) starting from the last
 *              row. dp[0] is the answer, using O(n) space.
 *
 * Approach:    Top-down memo
 * Complexity:  time O(n^2), space O(n^2)
 * Also see:    _1: Bottom-up with one row
 * Submitted:   2024-01-17 (submission 1148127559, AC)
 */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int dp[][] = new int[m][m];
        for(int [] arr : dp){
            Arrays.fill(arr,-1); 
        }
        return solve(0,0,m,triangle,dp); 
    }
    public int solve(int i, int j, int m,List<List<Integer>> triangle, int[][] dp){
        if(i == m-1){
            return triangle.get(i).get(j); 
        }
        if(dp[i][j] != -1) return dp[i][j];
        int path1 = triangle.get(i).get(j) + solve(i+1,j,m,triangle,dp);
        int path2 = triangle.get(i).get(j) + solve(i+1,j+1,m,triangle,dp);
        return dp[i][j] = Math.min(path1, path2); 
    }
}