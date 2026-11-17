class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for(int num : nums){
            int count = countMap.getOrDefault(num,0);
            countMap.put(num, count +1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> {
                return (b.count - a.count); 
            }
        );

        for(var entry : countMap.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();

            Pair p = new Pair(num, count);
            pq.add(p);
        }
        List<Integer> result = new LinkedList<>();
        while(k !=0){
            Pair p = pq.poll();
            result.add(p.number);
            k--; 
        }
        return result.stream().mapToInt(num -> num.intValue()).toArray();

    }
    class Pair{
        int number; 
        int count; 
        public Pair(int number, int count){
            this.number = number; 
            this.count = count; 
        }
    }
}