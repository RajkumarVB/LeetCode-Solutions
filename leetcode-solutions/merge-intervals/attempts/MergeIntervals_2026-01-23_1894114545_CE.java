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
       
        return result.toArray(new int[result.size()][2]);
    }
}