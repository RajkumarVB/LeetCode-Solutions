class Solution {
    public void moveZeroes(int[] nums) {
        int left =-1;
        int n = nums.length; 
        for(int i =0 ; i<n ;i++){
            if(nums[i] == 0){
                left = i;
                break;
            } 
        }
        if(left ==-1) return ; 
        for(int j = left+1; j<n; j++){
            if(nums[j] != 0){
                swap(nums,left,j);
                left++;
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }
}