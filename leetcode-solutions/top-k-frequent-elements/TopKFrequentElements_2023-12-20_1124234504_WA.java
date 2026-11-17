class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> ansList = new ArrayList<>();

        // element -> count map
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int element : nums){
            map.put(element,map.getOrDefault(element,0)+1);
        }

        // freq -> List of element map
        Comparator<Integer> customComparator = (a,b) -> b-a;
        Map<Integer,List<Integer>> freqMap = new TreeMap<>(customComparator);

        for(var entry : map.entrySet()){
            int element = entry.getKey();
            int freq = entry.getValue();

            if(!freqMap.containsKey(freq)) freqMap.put(freq, new ArrayList<>());
            freqMap.get(freq).add(element);
        }

        for(var entry : freqMap.entrySet()){
            if(k ==0 ) break;
            ansList.addAll(entry.getValue());
            k -- ;
        }

        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}