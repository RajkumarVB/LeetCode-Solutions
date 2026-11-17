class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> taskCount = new HashMap<>();

        for(char task : tasks){
            int count = taskCount.getOrDefault(task,0);
            taskCount.put(task, count + 1);
        }

        PriorityQueue<Task> pq = new PriorityQueue<>((t1,t2) -> t1.readyTime - t2.readyTime);

        for(var entry : taskCount.entrySet()){
            char task = entry.getKey();
            int count = entry.getValue();

            pq.add(new Task(task, 0));
            taskCount.put(task, count -1);
        }
        int time = 0; 

        while(!pq.isEmpty()){
            
            // no task can be executed now.
            if(pq.peek().readyTime > time){
                time ++; 
                continue; 
            }

            char task = pq.peek().task;
            int readyTime = pq.peek().readyTime;
            pq.poll();

            int leftCount = taskCount.get(task); 
            if(leftCount >0){
                taskCount.put(task, leftCount-1);
                pq.add(new Task(task, readyTime+n+1));
            }
            time++; 

        }
        return time; 
    }

    record Task(char task, int readyTime){

    }
}