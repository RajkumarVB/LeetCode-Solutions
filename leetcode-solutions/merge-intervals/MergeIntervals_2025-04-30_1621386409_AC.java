class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            if(i1[0] == i2[0]){
                return i1[1] - i2[1]; 
            }
            return i1[0] - i2[0]; 
        });

        LinkedList<int[]> mergedIntervals = new LinkedList<>(); 
        

        int n = intervals.length; 
        for(int i=0; i<n;i++){
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < intervals[i][0]){
                mergedIntervals.add(new int[]{intervals[i][0], intervals[i][1]}); 
            }else{
                int[] lastInterval = mergedIntervals.getLast(); 
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]); 
            }
        }

        
        
        int k = 0; 
        int[][] result = new int[mergedIntervals.size()][2]; 
        for(int[] interval : mergedIntervals){
            result[k] = interval;
            k++;
        }
        return result; 
    }
}