class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length; 
        if(n ==0) return 0; 
        Arrays.sort(nums);
        int result =1 , count =1, prev = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i]-1 == prev){
                count ++; 
                prev = nums[i];
            }else if(nums[i] != prev){
                count = 1; 
                prev = nums[i];
            }
            result = Math.max(result, count);
        }
        return result; 
    }
}