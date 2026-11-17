class Solution {
    public int maxSubArray(int[] nums) {
        // Using Kadane's Algo 
        int res = Integer.MIN_VALUE; 
        int sum = 0 ; 
        int n = nums.length; 
        for(int i=0 ; i<n ;i++){
            sum += nums[i];
            if(sum > res){
                res = sum ;
            }
            if(sum < 0) sum = 0 ;
        }
        return res; 
    }
}