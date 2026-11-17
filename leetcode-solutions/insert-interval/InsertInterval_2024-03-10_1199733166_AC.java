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