class Solution {
    public void nextPermutation(int[] nums) {
        int breakingPointIndex = -1; 
        int n = nums.length; 
        for(int i =n-1 ; i>=1; i--){
            if(nums[i-1] < nums[i]){
                breakingPointIndex = i-1;
                break;
            }
        }
        if(breakingPointIndex ==-1){
            reverse(nums,0,n-1);
            return;
        }
        for(int i = n-1; i>breakingPointIndex; i--){
            if(nums[i] > nums[breakingPointIndex]){
                swap(nums,i,breakingPointIndex);
                break;
            }
        }
        reverse(nums,breakingPointIndex+1,n-1);
    }
    public static void reverse(int[]nums , int i , int j){
        while(i <j){
            swap(nums, i , j);
            i ++;
            j--;
        }
    }
    public static void swap(int[]nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }
}