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