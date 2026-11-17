class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(points.length < k) {
            throw new RuntimeException("Bad Input"); 
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(
            (p1, p2) -> {
                return (int)(p1.distance - p2.distance); 
            }
        );

        for(int[] point : points){
            int x = point[0];
            int y = point[1];

            double distance = Math.pow(x,2) + Math.pow(y,2);
            pq.add(new Point(x, y, distance));
        }

        int[][] result = new int[k][2];

        for(int i=0; i<k; i++){
            Point p = pq.poll();
            result[i] = new int[]{p.x, p.y};
        }


        return result;
    }

    record Point(int x, int y, double distance){

    }
}