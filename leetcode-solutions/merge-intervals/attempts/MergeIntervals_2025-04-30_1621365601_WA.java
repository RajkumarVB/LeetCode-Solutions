class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            if(i1[0] == i2[0]){
                return i1[1] - i2[1]; 
            }
            return i1[0] - i2[0]; 
        });

        int n = intervals.length; 
        int i =0; 
        List<int[]> resultIntervals = new LinkedList<>();

        while(i < n) {
            int resultStart = intervals[i][0]; 
            int resultEnd = intervals[i][1]; 


            int j = i+1; 
            while(j < n && resultEnd >= intervals[j][0]){
                resultEnd = Math.max(intervals[j][1], intervals[i][1]) ; 
                j++; 
            }
            resultIntervals.add(new int[]{resultStart, resultEnd}); 
            i = j; 
        }


        int[][] result = new int[resultIntervals.size()][2]; 
        int k =0; 
        for(int[] interval : resultIntervals){
            result[k] = interval; 
            k++; 
        }
        return result; 
    }
}


// [0,2]  [1,4] [3,5]
