class Solution {
    public void nextPermutation(int[] nums) {
        int i, j; 
        int n = nums.length; 
        for(i = n-2; i>=0;i--){
            if(nums[i] < nums[i+1]) break;
        }
        if(i==-1){
            reverse(nums,0,n-1);
            return; 
        }
        for(j = n-1; j>=0; j--){
            if(nums[j] > nums[i]) break;
        }
        swap(nums,i,j);
        reverse(nums,i+1,n-1);
    }
    public static void reverse(int[] arr, int i, int j){
        while(i < j){
            swap(arr,i,j);
            i ++;
            j--;
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp; 
    }
}