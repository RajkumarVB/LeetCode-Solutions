/*
 * 72. Edit Distance  [Medium]
 * https://leetcode.com/problems/edit-distance/
 * Topics: String, Dynamic Programming
 *
 * Problem:     Return the minimum number of single-character inserts, deletes or replaces
 *              needed to turn word1 into word2.
 * Example:     "horse", "ros" -> 3
 * Constraints: lengths <= 500
 *
 * Key idea:    f(i, j): if chars match, f(i-1, j-1); else 1 + min(insert f(i, j-1), delete
 *              f(i-1, j), replace f(i-1, j-1)). Base: f(i,0)=i, f(0,j)=j.
 *
 * Approach:    Two rolling rows
 * Complexity:  time O(m*n), space O(n)
 * Also see:    _1: Top-down memo; _2: Bottom-up 2-D tabulation
 * Submitted:   2024-04-09 (submission 1227726125, AC)
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] prev = new int[n+1];

        for(int j=0; j<=n; j++){
            prev[j] = j; 
        }
        
        for(int i=1; i<=m; i++){
            int[] curr = new int[n+1];    
            curr[0] = i;
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    curr[j] = prev[j-1]; 
                } else{
                    int insert = 1 + curr[j-1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j-1]; 
                    curr[j] = Math.min(Math.min(insert,delete),replace); 
                }
            }
            prev = curr; 
        }
        return prev[n];
    }
}