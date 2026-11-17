class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>(); 
        for(int element : nums){
            int count = freqMap.getOrDefault(element, 0); 
            freqMap.put(element,count+1); 
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue())); 
        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            pq.add(entry); 
        }
        List<Integer> result = new LinkedList<>(); 
        while(k>0){
            Map.Entry<Integer,Integer> entry = pq.poll(); 
            result.add(entry.getKey()); 
            k--;
        }
        return result.stream().mapToInt(Integer::intValue).toArray(); 
    }
}