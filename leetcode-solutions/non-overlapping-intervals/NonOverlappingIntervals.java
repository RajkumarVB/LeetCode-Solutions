/*
 * 435. Non-overlapping Intervals  [Medium]
 * https://leetcode.com/problems/non-overlapping-intervals/
 * Topics: Array, Dynamic Programming, Greedy, Sorting
 *
 * Problem:     Return the minimum number of intervals to remove so the rest don't overlap
 *              (touching endpoints are fine).
 * Example:     [[1,2],[2,3],[3,4],[1,3]] -> 1
 * Constraints: n <= 1e5
 *
 * Key idea:    Greedy: sort by start; on overlap, remove one and keep the interval with the
 *              smaller end (it leaves more room). Sorting by end and counting non-
 *              overlapping intervals is equivalent.
 *
 * Approach:    Sort by start, keep the smaller end on overlap
 * Complexity:  time O(n log n), space O(1)
 * Submitted:   2024-03-10 (submission 1199759013, AC)
 */

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); 
        int n = intervals.length; 
        int prevEnd = intervals[0][1]; 
        int result = 0; 
        for(int i=1; i<n; i++){
            if(prevEnd <= intervals[i][0]){
                prevEnd = intervals[i][1]; 
            } else{
                result ++; 
                prevEnd = Math.min(prevEnd,intervals[i][1]); 
            }
        }
        return result; 
    }
}