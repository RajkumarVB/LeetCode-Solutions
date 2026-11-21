/*
 * 778. Swim in Rising Water  [Hard]
 * https://leetcode.com/problems/swim-in-rising-water/
 * Topics: Array, Binary Search, Depth-First Search, Breadth-First Search, Union-Find,
 *         Minimax, Heap (Priority Queue), Matrix, Dijkstra's Algorithm
 *
 * Problem:     At time t you can swim through cells with elevation <= t. Return the
 *              earliest t to get from (0,0) to (n-1,n-1).
 * Example:     [[0,2],[1,3]] -> 3
 * Constraints: n <= 50, unique elevations
 *
 * Key idea:    Minimise the maximum elevation along a path: Dijkstra-like search with a
 *              min-heap keyed by the max height so far. The first time you pop the target,
 *              that's the answer. (Binary search on t + BFS also works.)
 *
 * Approach:    Min-heap on path max height (modified Dijkstra)
 * Complexity:  time O(n^2 log n), space O(n^2)
 * Submitted:   2024-04-22 (submission 1238897502, AC)
 */

class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.height - b.height); 
        int m = grid.length, n = grid[0].length; 
        boolean[][] visited = new boolean[m][n]; 
        for(boolean[] arr : visited){
            Arrays.fill(arr,false); 
        }

        pq.add(new Tuple(grid[0][0], 0, 0)); 
        visited[0][0] = true; 
        while(!pq.isEmpty()){
            Tuple t = pq.poll(); 
            int height = t.height; 
            int r = t.r; 
            int c = t.c; 

            if(r == m-1 && c == n-1) return height; 

            int[][] directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}}; 
            for(int[] dir : directions){
                int newR = r + dir[0];
                int newC = c + dir[1];

                if(newR >= 0 && newR < m && newC >= 0 && newC <n && !visited[newR][newC]){
                    int maxHeight = Math.max(height, grid[newR][newC]); 
                    pq.add(new Tuple(maxHeight, newR, newC)); 
                    visited[newR][newC] = true; 
                }
            }
        }
        return 1; // this will never execute 
    }

    record Tuple(int height, int r, int c){

    }
}