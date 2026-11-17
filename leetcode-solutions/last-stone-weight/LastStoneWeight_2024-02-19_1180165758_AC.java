class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((ele1, ele2) -> ele2 - ele1); 
        for(int stone : stones){
            pq.offer(stone); 
        }
        while(pq.size() > 1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if(stone1 - stone2 != 0){
                pq.offer(stone1 - stone2); 
            }
        }
        return pq.isEmpty() ? 0 : pq.poll(); 
    }
}