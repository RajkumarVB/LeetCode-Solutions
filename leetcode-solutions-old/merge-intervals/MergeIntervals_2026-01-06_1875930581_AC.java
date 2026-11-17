class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i, j) -> {
            if(i[0] == j[0]){
                return i[1] - j[1];
            }
            return i[0] - j[0];
        });

        List<int[]> result = new LinkedList<>();
        int n = intervals.length;
        for(int i=0; i<n; i++){
            if(result.isEmpty() || intervals[i][0] > result.getLast()[1]){
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            }else{
                // overlapping 
                int[] interval = result.removeLast();
                interval[1] = Math.max(interval[1], intervals[i][1]);
                result.add(interval);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}