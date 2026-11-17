class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> countMap = new HashMap<>();
        int n = nums.length; 
        for(int num : nums){
            int count = countMap.getOrDefault(num,0);
            countMap.put(num, count+1);
        }

        
        List<List<Integer>> frequencyList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            frequencyList.add(new LinkedList<>());
        }

        for(var entry : countMap.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            frequencyList.get(count).add(num);
        }
        List<Integer> result = new LinkedList<>();
        System.out.println(frequencyList);
        for(int i=n; i>0; i--){
            if(frequencyList.get(i).size() == 0) continue; 
            if(k != 0){
                result.addAll(frequencyList.get(i));
                System.out.println(frequencyList.get(i).size());
                k -= frequencyList.get(i).size();
            }
            if(k ==0) break; 
        }
        return result.stream().mapToInt(num -> num.intValue()).toArray();

    }
}