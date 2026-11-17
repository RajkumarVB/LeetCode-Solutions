class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length; 
        HashMap<Integer,Integer> freqMap = new HashMap<>(); 
        for(int ele : nums){
            int count = freqMap.getOrDefault(ele, 0); 
            freqMap.put(ele, count + 1); 
        }

        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(n+1); 
        // You need n + 1 buckets, since you'll not store anything at 0 

        for(int i=0; i<=n;i++){
            buckets.add(new ArrayList<>()); 
        }

        for(var key : freqMap.keySet()){
            int count = freqMap.get(key); 
            buckets.get(count).add(key); 
        }

        List<Integer> ans = new LinkedList<>(); 


        // You could add evething in the bucket, since it's given that the ans is unique. 
        // You will not find a test case like [1,1,2,2,3,3] and k = 2; 
        // So we are good. 
        for(int i=n; i>=1 && k > 0; i--){
            int elements = buckets.get(i).size(); 
            ans.addAll(buckets.get(i)); 
            k -= elements; 
        }

        return ans.stream()
            .mapToInt((Integer ele) -> ele.intValue())
            .toArray();
    }
}