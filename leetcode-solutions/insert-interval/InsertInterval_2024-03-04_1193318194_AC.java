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