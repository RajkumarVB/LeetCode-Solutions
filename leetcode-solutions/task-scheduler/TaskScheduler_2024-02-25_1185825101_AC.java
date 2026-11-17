class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>(); 
        for(char c : tasks){
            int count = map.getOrDefault(c,0); 
            map.put(c, count-1); 
        }
        // Using Min Heap to leverage heapify. 
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.values());
        Deque<Pair> deque = new LinkedList<>(); 
        int time = 0; 
        while(!pq.isEmpty() || !deque.isEmpty()){
            if(!pq.isEmpty()){
                int job = pq.poll(); 
                job ++; 
                if(job != 0) deque.addLast(new Pair(job,time+n)); 
            }
            while(!deque.isEmpty() && deque.getFirst().time == time){
                pq.offer(deque.removeFirst().job); 
            }
            time ++; 
        }
        return time; 

    }
    record Pair(int job, int time){

    }
}