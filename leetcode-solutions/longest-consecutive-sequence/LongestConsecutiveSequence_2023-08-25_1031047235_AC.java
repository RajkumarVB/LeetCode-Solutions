class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length; 
        if(n==0) return 0; 
        int result = 1; 
        Arrays.sort(nums);
        int lastSmaller = Integer.MIN_VALUE; 
        int count = 0; 
        for(int i =0 ; i<n ;i++){
            if(nums[i] -1 == lastSmaller){
                count += 1; 
            } else if(nums[i] == lastSmaller){
                continue; 
            } else {
                count = 1; 
            }
            lastSmaller = nums[i];
            result = Math.max(result, count);
        }
        return result ; 
    }
}