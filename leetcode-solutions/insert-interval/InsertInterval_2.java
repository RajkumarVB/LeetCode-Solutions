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
 * Approach:    Append, sort and merge intervals
 * Complexity:  time O(n log n), space O(n)
 * Also see:    _1: Three-phase linear scan
 * Submitted:   2024-03-04 (submission 1193318194, AC)
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> intervalsList = new ArrayList<>();
        intervalsList.add(new Interval(newInterval[0],newInterval[1]));
        for(int[] interval : intervals){
            intervalsList.add(new Interval(interval[0],interval[1])); 
        }
        intervalsList.sort((i, j) -> i.start - j.start); 
        List<Interval> resultList = new ArrayList<>(); 
        resultList.add(intervalsList.getFirst()); 
        for(int i=1; i<intervalsList.size(); i++){
            Interval lastInterval = resultList.getLast(); 
            Interval interval = intervalsList.get(i); 
            if(lastInterval.end >= interval.start){
                lastInterval.end = Math.max(interval.end, lastInterval.end);
            } else{
                resultList.add(interval); 
            }
        }
        int[][] resultIntervals = new int[resultList.size()][];
        for(int i=0; i<resultList.size(); i++){
            Interval interval = resultList.get(i);
            resultIntervals[i] = new int[]{interval.start,interval.end}; 
        }
        return resultIntervals;
    }

    class Interval{
        int start; 
        int end; 
        public Interval(int start, int end){
            this.start = start; 
            this.end = end; 
        }
    }
}