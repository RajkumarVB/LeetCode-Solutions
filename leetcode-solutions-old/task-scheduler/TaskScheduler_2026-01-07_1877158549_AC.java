class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> freqMap = new HashMap<>();
        
        
        for(char task : tasks){
            int count = freqMap.getOrDefault(task,0);
            freqMap.put(task, count + 1); 
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> {
            return j - i; 
        });

        for(var value : freqMap.values()){
           pq.add(value);
        }

        Deque<Task> q = new LinkedList<>();
        int time = 0; 

        while(!pq.isEmpty() || !q.isEmpty()){
            time ++; 
            
            while(!q.isEmpty() && q.getFirst().time <= time){
                Task t = q.removeFirst();
                pq.add(t.taskCount); 
            }

            if(!pq.isEmpty()){
                int taskCount = pq.poll();
                if(taskCount -1 != 0){
                    q.add(new Task(taskCount -1 , time + n + 1)); 
                }
            }
      
            
        }
        return time; 

    }

    record Pair(int count, char task ){

    }

    record Task(int taskCount, int time){

    }
}

