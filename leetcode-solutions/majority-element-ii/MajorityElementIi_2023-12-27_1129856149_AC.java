class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>(); 
        int n = nums.length; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        for(int element : nums){
            map.put(element, map.getOrDefault(element,0) + 1 ); 
        }


        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > n/3 ){
                ans.add(entry.getKey());
            }
        }
        return ans; 
    }
}