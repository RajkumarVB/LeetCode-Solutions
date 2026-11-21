/*
 * 56. Merge Intervals  [Medium]
 * https://leetcode.com/problems/merge-intervals/
 * Topics: Array, Sorting, Quicksort
 *
 * Problem:     Merge all overlapping intervals.
 * Example:     [[1,3],[2,6],[8,10],[15,18]] -> [[1,6],[8,10],[15,18]]
 * Constraints: n <= 1e4
 *
 * Key idea:    Sort by start. If the current interval starts at or before the last merged
 *              interval's end, extend that end; otherwise start a new interval.
 *
 * Approach:    Sort by start + extend last merged
 * Complexity:  time O(n log n), space O(n)
 * Submitted:   2026-01-23 (submission 1894114807, AC)
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[][]{};
        
        Arrays.sort(intervals, (i1,i2) -> i1[0] - i2[0]);

        List<int[]> merged = new LinkedList<>();

        merged.add(intervals[0]);
        int n = intervals.length; 
        
        for(int i=1; i<n; i++){
            int[] lastInterval = merged.getLast();
            int[] currentInterval = intervals[i];
            if(currentInterval[0] <= lastInterval[1]){
                // merge it
                lastInterval[1] = Math.max(currentInterval[1], lastInterval[1]); 
            }else{
                merged.add(currentInterval);
            }
        }
       
        return merged.toArray(new int[merged.size()][2]);
    }
}