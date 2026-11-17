class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length; 
        int left =0, right = n-1, mid =0; 
        while(mid <= right){
            if(nums[mid] == 0){
                swap(nums,left,mid); 
                left ++; 
                mid++; 
            } else if(nums[mid] == 2){
                swap(nums,mid,right); 
                right --; 
            } else{
                mid ++; 
                continue; 
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i]; 
        nums[i] = nums[j];
        nums[j] = temp; 
    }
}