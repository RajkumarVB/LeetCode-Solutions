/*
 * 973. K Closest Points to Origin  [Medium]
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * Topics: Array, Math, Divide and Conquer, Geometry, Sorting, Heap (Priority Queue),
 *         Quickselect, K-D Tree
 *
 * Problem:     Return the k points closest to the origin.
 * Example:     points=[[1,3],[-2,2]], k=1 -> [[-2,2]]
 * Constraints: n <= 1e4
 *
 * Key idea:    Compare squared distances (no sqrt). A min-heap of all points then k polls
 *              works; better is a max-heap of size k (O(n log k)), or quickselect (O(n)
 *              average).
 *
 * Approach:    Min-heap of all points, poll k
 * Complexity:  time O(n log n), space O(n)
 * Submitted:   2024-02-20 (submission 1180192813, AC)
 */

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> {
            int x1 = p1.x; 
            int y1 = p1.y; 
            int x2 = p2.x; 
            int y2 = p2.y; 
            double dist1 = Math.pow(x1,2) + Math.pow(y1,2); 
            double dist2 = Math.pow(x2,2) + Math.pow(y2,2); 
            return Double.compare(dist1,dist2);
        });
        for(int[] point : points){
            Pair p = new Pair(point[0], point[1]); 
            pq.offer(p); 
        }
        int[][] result = new int[k][2]; 
        for(int i=0; i<k; i++){
            Pair p = pq.poll();
            result[i][0] = p.x; 
            result[i][1] = p.y; 
        }
        return result;
    }
    record Pair(int x, int y){

    }
}