class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair a, Pair b) -> {
            double aRatio = ((double)(a.x + 1) /  (a.y + 1)) -  ((double)(a.x) /  (a.y)); 
            double bRatio = ((double)(b.x + 1) /  (b.y + 1)) -  ((double)(b.x) /  (b.y)); 
            return Double.compare(bRatio, aRatio);
        }); 

        for(int[] cls : classes){
            pq.add(new Pair(cls[0], cls[1])); 
        }

        while(extraStudents != 0){
            Pair p = pq.poll(); 
            p.x = p.x + 1 ; 
            p.y = p.y + 1; 
            pq.add(p); 

            
            extraStudents --; 
        }

        double passRatioSum = 0; 
        for(Pair p : pq){
            passRatioSum += ( ((double)p.x) / p.y ); 
        }
        return (passRatioSum / classes.length); 
    }
    class Pair{
        int x; 
        int y; 
        public Pair(int x, int y){
            this.x = x; 
            this.y = y; 
        }
    }

    // private int findMaxPossibleIncreaseIndex(int[][] classes){
    //     double maxIncrease = Integer.MIN_VALUE; 
    //     int resultIndex = 0;  
    //     int i =0; 
    //     for(int[] cls : classes){
    //         double increase = (((double) cls[0] + 1) / (cls[1] + 1)) - ( ((double)cls[0]) / cls[1] );
    //         if(increase > maxIncrease){
    //             maxIncrease = increase; 
    //             resultIndex = i; 
    //         }
    //         i++;  
    //     }
    //     return resultIndex; 
    // }
}