class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length; 
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    public static void reverse(int [] arr, int left , int right){
        int i = left, j = right ;
        while(i <j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp ; 

            i++; 
            j--;
        }
    }
}