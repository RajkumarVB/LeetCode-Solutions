class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length; 
        int zeroPointer = -1; 
        for(int i =0;i<n ;i++){
            if(nums[i] ==0){
                zeroPointer =i; 
                break; 
            }
        }
        if(zeroPointer ==-1) return; 
        for(int i=zeroPointer+1; i<n; i++){
            if(nums[i] != 0){
                swap(nums,zeroPointer,i);
                zeroPointer++;
            }
        }
    }
    public static void swap(int[] nums, int left ,int right){
        int temp ; 
        temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp; 
    }
}