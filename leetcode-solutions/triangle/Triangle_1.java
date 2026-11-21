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
 * Approach:    Bottom-up with one row
 * Complexity:  time O(n^2), space O(n)
 * Also see:    _2: Top-down memo
 * Submitted:   2024-01-17 (submission 1148132086, AC)
 */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] next = new int[m]; 
        int [] curr = new int[m];
        
        for(int j=0; j<m; j++){
            next[j] = triangle.get(m-1).get(j); 
        }
        for(int i=m-2; i>=0 ; i--){
            for(int j=0; j<=i; j++){
                int path1 = triangle.get(i).get(j) + next[j];
                int path2 = triangle.get(i).get(j) + next[j+1];
                curr[j] = Math.min(path1, path2); 
            }
            next = curr; 
        }

        return next[0]; 
    }
}