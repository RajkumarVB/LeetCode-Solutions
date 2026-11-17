class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> {
            int x1 = p1.x; 
            int y1 = p1.y; 
            int x2 = p2.x; 
            int y2 = p2.y; 
            double dist1 = Math.pow(x1,2) + Math.pow(y1,2); 
            double dist2 = Math.pow(x2,2) + Math.pow(y2,2); 
            if(dist1 == dist2) return 0;
            if(dist1 > dist2) return 1; 
            return -1; 
        });
        for(int[] point : points){
            Pair p = new Pair(point[0], point[1]); 
            pq.offer(p); 
        }
        int[][] result = new int[k][2]; 
        for(int i=0; i<k; i++){
            Pair p = pq.poll();
            result[i][0] = p.x; 
            result[i][1] = p.y; 
        }
        return result;
    }
    record Pair(int x, int y){

    }
}