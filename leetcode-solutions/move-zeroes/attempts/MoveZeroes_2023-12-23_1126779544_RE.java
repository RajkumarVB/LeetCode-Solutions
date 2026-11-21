class Solution {
    public void moveZeroes(int[] nums) {
        // Non zero pointer points to zero, and there we should fill next non zero element 

        int n = nums.length; 
        int nonZeroPointer = -1; 
        for(int i =0; i<n; i++){
            if(nums[i] == 0){
                nonZeroPointer = i; 
                break; 
            } 
        }
        if(nonZeroPointer == -1) return; 


        int i = 0; 
        for(; i<n; i++){
            if(nums[i] != 0){
                swap(nums, i, nonZeroPointer); 
                nonZeroPointer++; 
            }
        }
    }
    public static void swap(int[] nums, int i , int j){
        int temp = nums[i] ; 
        nums[i] = nums[j] ;
        nums[j] = temp ; 
    }
}