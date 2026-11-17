class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length; 
        List<int[]> result = new LinkedList<>(); 
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        result.add(intervals[0]);
        for(int i=1; i<n; i++){
            int[] lastInterval = result.getLast(); 
            if(lastInterval[1] >= intervals[i][0]){
                lastInterval[1] = Math.max(intervals[i][1],lastInterval[1]);
            } else{
                result.add(intervals[i]); 
            }
        }
        int[][] resultIntervals = new int[result.size()][];
        for(int i=0; i<result.size(); i++){
            resultIntervals[i] = result.get(i); 
        }
        return resultIntervals;
    }
}