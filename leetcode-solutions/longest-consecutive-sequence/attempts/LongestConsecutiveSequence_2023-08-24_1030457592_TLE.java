class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length; 
        if(n==0) return 0; 
        int result = 1; 
        for(int i=0; i<n; i++){
            int count =1 ; 
            int element = nums[i] +1 ;
            while(linearSearch(nums,element)){
                count ++; 
                element ++;
            }
            result = Math.max(result, count);
        }
        return result ; 
    }
    public static boolean linearSearch(int[] nums, int target){
        for(int i=0;i <nums.length;i++){
            if(nums[i] == target){
                return true; 
            }
        }
        return false; 
    }
}