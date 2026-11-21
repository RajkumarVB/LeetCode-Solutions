/*
 * 57. Insert Interval  [Medium]
 * https://leetcode.com/problems/insert-interval/
 * Topics: Array
 *
 * Problem:     Insert a new interval into a sorted list of non-overlapping intervals,
 *              merging where needed.
 * Example:     [[1,3],[6,9]] + [2,5] -> [[1,5],[6,9]]
 * Constraints: n <= 1e4
 *
 * Key idea:    Three phases in one pass: copy intervals ending before the new one starts;
 *              merge all that overlap it (min start, max end); copy the rest.
 *
 * Approach:    Three-phase linear scan
 * Complexity:  time O(n), space O(n)
 * Also see:    _2: Append, sort and merge intervals
 * Submitted:   2024-03-10 (submission 1199733166, AC)
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>(); 
        int n = intervals.length, i =0; 
        //Intervals which comes before new Interval
        while(i<n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++; 
        }

        // Intervals which are overlapping 
        while(i < n && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++; 
        }
        result.add(newInterval);

        //Intervals which comes after new Interval
        while(i < n){
            result.add(intervals[i]); 
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}