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