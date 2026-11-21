/*
 * 931. Minimum Falling Path Sum  [Medium]
 * https://leetcode.com/problems/minimum-falling-path-sum/
 * Topics: Array, Dynamic Programming, Matrix
 *
 * Problem:     In an n x n matrix, a falling path picks one cell per row, moving down,
 *              down-left or down-right. Return the minimum path sum.
 * Example:     [[2,1,3],[6,5,4],[7,8,9]] -> 13
 * Constraints: n <= 100
 *
 * Key idea:    dp[i][j] = matrix[i][j] + min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]). Keep
 *              only the previous row; the answer is the min of the last row.
 *
 * Approach:    Row-by-row DP with one previous row
 * Complexity:  time O(n^2), space O(n)
 * Submitted:   2024-01-18 (submission 1149089103, AC)
 */

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; 
        int[] curr = new int[n];
        int[] prev = new int[n];

        for(int j=0; j<n; j++){
            prev[j] = matrix[0][j]; 
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                int up, left, right; 
                up = left = right = Integer.MAX_VALUE; 
                if(i >= 1) up = matrix[i][j] + prev[j];
                if(i>= 1 && j>=1) left = matrix[i][j] + prev[j-1];
                if(i>= 1 && j<=n-2) right = matrix[i][j] + prev[j+1];
                curr[j] = Math.min(Math.min(up,left),right);
            }
            prev = Arrays.copyOf(curr, n);
        }
        int ans = Integer.MAX_VALUE; 
        for(int j=0; j<n; j++){
            ans = Math.min(prev[j], ans);
        }
        return ans; 
    }
}