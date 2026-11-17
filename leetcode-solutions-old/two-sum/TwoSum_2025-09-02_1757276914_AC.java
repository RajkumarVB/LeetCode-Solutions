class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numberToIndexMap = new HashMap<>(); 
        for(int i=0; i<nums.length; i++){
            int numToLookFor = target - nums[i]; 
            if(numberToIndexMap.containsKey(numToLookFor)){
                return new int[]{i,numberToIndexMap.get(numToLookFor)};
            }
            numberToIndexMap.put(nums[i],i); 
        }
        return new int[]{-1,-1};
    }
}