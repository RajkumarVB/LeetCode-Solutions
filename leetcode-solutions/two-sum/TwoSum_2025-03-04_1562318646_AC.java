class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        // ele -> index map 
        for(int i=0; i<n; i++){
            int eleToLookFor = target - nums[i]; 
            if(map.containsKey(eleToLookFor)){
                return new int[]{i, map.get(eleToLookFor)}; 
            }
            map.put(nums[i], i); 
        }
        return new int[]{-1,-1};
    }
}