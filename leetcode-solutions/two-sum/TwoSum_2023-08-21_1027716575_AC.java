class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length; 
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i =0 ; i<n ; i++){
            int elementToLookFor = target - nums[i];
            if(hashMap.containsKey(elementToLookFor)) return new int[] {i,hashMap.get(elementToLookFor)} ; 
            hashMap.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}