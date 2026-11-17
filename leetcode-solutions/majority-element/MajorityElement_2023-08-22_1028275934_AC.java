class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int n = nums.length; 
        for(int i=0; i<n; i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }
        for(var entry : hashMap.entrySet()){
            if(entry.getValue() > n/2) return entry.getKey();
        }
        return -1; 
    }
}