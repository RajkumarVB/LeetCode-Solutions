/*
 * 62. Unique Paths  [Medium]
 * https://leetcode.com/problems/unique-paths/
 * Topics: Math, Dynamic Programming, Combinatorics
 *
 * Problem:     A robot moves only right or down on an m x n grid. Count the paths from the
 *              top-left to the bottom-right.
 * Example:     m=3, n=7 -> 28
 * Constraints: m, n <= 100
 *
 * Key idea:    paths(i, j) = paths(i-1, j) + paths(i, j-1), with the first row and column
 *              all 1. Math shortcut: C(m+n-2, m-1).
 *
 * Approach:    Top-down memo
 * Complexity:  time O(m*n), space O(m*n)
 * Also see:    _2: Bottom-up 2-D table
 * Submitted:   2026-01-21 (submission 1892457152, AC)
 */

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