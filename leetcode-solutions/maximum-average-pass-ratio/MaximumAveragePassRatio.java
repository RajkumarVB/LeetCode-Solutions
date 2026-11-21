/*
 * 1792. Maximum Average Pass Ratio  [Medium]
 * https://leetcode.com/problems/maximum-average-pass-ratio/
 * Topics: Array, Greedy, Heap (Priority Queue)
 *
 * Problem:     Each class has pass/total students. Add extraStudents guaranteed passers to
 *              classes to maximise the average pass ratio.
 * Example:     classes=[[1,2],[3,5],[2,2]], extra=2 -> 0.78333
 * Constraints: <= 1e5 classes and extra students
 *
 * Key idea:    Greedy with a max-heap ordered by the gain (p+1)/(t+1) - p/t. Always give
 *              the next student to the class with the biggest gain, then push it back with
 *              its new gain.
 *
 * Approach:    Max-heap by marginal gain
 * Complexity:  time O((n + extra) log n), space O(n)
 * Submitted:   2025-09-01 (submission 1755983377, AC)
 */

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
}