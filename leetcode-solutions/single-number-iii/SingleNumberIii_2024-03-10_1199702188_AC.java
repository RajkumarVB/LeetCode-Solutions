class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>(); 
        for(int ele : nums){
            int count = map.getOrDefault(ele,0);
            map.put(ele,count+1); 
        }
        List<Integer> result = new LinkedList<>();
        for(var entry : map.entrySet()){
            if(entry.getValue() == 1) result.add(entry.getKey()); 
        }
        return new int[]{result.get(0), result.get(1)}; 
    }
}