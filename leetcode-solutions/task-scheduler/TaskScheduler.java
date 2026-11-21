/*
 * 621. Task Scheduler  [Medium]
 * https://leetcode.com/problems/task-scheduler/
 * Topics: Array, Hash Table, Greedy, Sorting, Heap (Priority Queue), Counting
 *
 * Problem:     Run CPU tasks (letters) so that identical tasks are at least n intervals
 *              apart; idle slots are allowed. Return the minimum number of intervals.
 * Example:     [A,A,A,B,B,B], n=2 -> 8 (A B idle A B idle A B)
 * Constraints: <= 1e4 tasks, n <= 100
 *
 * Key idea:    Simulate with a max-heap of remaining counts and a cooldown queue of (count,
 *              readyTime): always run the most frequent available task. Formula: max(len,
 *              (maxFreq - 1) * (n + 1) + #tasks with maxFreq).
 *
 * Approach:    Max-heap + cooldown queue simulation
 * Complexity:  time O(T log 26), space O(26)
 * Submitted:   2026-01-07 (submission 1877158549, AC)
 */

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

