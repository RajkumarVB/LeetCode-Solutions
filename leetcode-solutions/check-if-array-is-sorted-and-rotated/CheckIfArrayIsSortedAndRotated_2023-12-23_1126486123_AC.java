class Solution {
    public boolean check(int[] nums) {
        int falseCount = 0; 
        int n = nums.length; 
        for(int i=0; i<n; i++){
            if(nums[i] > nums[(i+1) % n ] ) falseCount ++; 
            if(falseCount > 1) return false; 
        }
        return falseCount <= 1 ;
    }
}