class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>(); 
        int n = nums.length; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        for(int element : nums){
            int count = map.getOrDefault(element,0);
            map.put(element, count + 1 ); 
        }

        for(var entry : map.entrySet()){
            if(entry.getValue() > n/3 ){
                ans.add(entry.getKey());
            }
        }

        return ans; 
    }
}