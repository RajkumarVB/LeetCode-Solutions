class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]); 

        Deque<int[]> result = new LinkedList<>(); 
        
        result.add(intervals[0]); 

        for(int[] interval : intervals){
            int[] lastInterval = result.getLast(); 
            if(lastInterval[1] >= interval[0]){
                // Overlapping 
                lastInterval[1] = Math.max(lastInterval[1],interval[1]); 
            } else{
                result.add(interval); 
            }
        }

        return result.toArray(new int[result.size()-1][]); 
    }
}