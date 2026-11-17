class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>(); 
        for(int ele : nums){
            int count = freqMap.getOrDefault(ele, 0); 
            freqMap.put(ele, count+1); 
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            return e2.getValue() - e1.getValue(); 
        });

        for(var entry : freqMap.entrySet()){
            pq.offer(entry); 
        }
        int[] ans = new int[k]; 
        for(int i=0; i<k; i++){
            var entry = pq.poll(); 
            ans[i] = entry.getKey(); 
        }
        return ans; 
    }
}