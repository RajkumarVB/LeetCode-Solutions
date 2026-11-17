class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length; 

        HashMap<Integer,Integer> freqMap = new HashMap<>(); 
        for(int element: nums){
            int count = freqMap.getOrDefault(element,0); 
            freqMap.put(element,count+1); 
        }

        ArrayList<List<Integer>> buckets = new ArrayList<>(n+1); 
        for(int i=0; i<=n; i++){
            buckets.add(new LinkedList<>()); 
        }

        for(int element : freqMap.keySet()){
            int freq = freqMap.get(element); 
            buckets.get(freq).add(element); 
        }
        List<Integer> result = new LinkedList<>(); 
        
        int i = n; 
        while(i > 0 && k>0){
            if(buckets.get(i).size() != 0){
                result.addAll(buckets.get(i)); 
                k -= buckets.get(i).size(); 
            }
            i --; 
        }
        // return result.stream().mapToInt(element -> element.intValue()).toArray(); 
        return result.stream().mapToInt(Integer::intValue).toArray(); 
    }
}