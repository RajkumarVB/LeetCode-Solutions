class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length; 
        int result =0 ; 
        for(int i=0; i<n; i++){
            int count = 1; 
            int element = nums[i];
            while(ls(nums,element+1)){
                count++;
                element ++; 
            }
            result = Math.max(result,count);
        }
        return result; 
    }
    public static boolean ls(int[] arr, int element){
        int n = arr.length; 
        for(int i =0; i<n ;i++){
            if(arr[i] == element) return true; 
        }
        return false; 
    }
}