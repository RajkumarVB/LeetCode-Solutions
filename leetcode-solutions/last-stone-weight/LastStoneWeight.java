/*
 * 1046. Last Stone Weight  [Easy]
 * https://leetcode.com/problems/last-stone-weight/
 * Topics: Array, Heap (Priority Queue)
 *
 * Problem:     Repeatedly smash the two heaviest stones: equal stones vanish, otherwise the
 *              difference remains. Return the last stone's weight (or 0).
 * Example:     [2,7,4,1,8,1] -> 1
 * Constraints: n <= 30
 *
 * Key idea:    Max-heap: poll two, push the difference if it's non-zero.
 *
 * Approach:    Max-heap simulation
 * Complexity:  time O(n log n), space O(n)
 * Submitted:   2026-01-19 (submission 1890073610, AC)
 */

class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length ==0) return 0; 
        PriorityQueue<Integer> pq = new PriorityQueue<>((s1, s2) -> s2-s1);
        for(int stone : stones){
            pq.add(stone);
        }

        while(pq.size() >= 2){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            
            if(stone1 == stone2) continue; 

            pq.add(stone1 - stone2);
        }

        if(pq.size() == 0) return 0; 
        return pq.peek();
    }
}