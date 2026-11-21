class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length ; 
        int res = Integer.MIN_VALUE;
        for(int i = 0; i<n ; i++){
            int sum = 0; 
            for(int j =i; j<n ; j++){
                sum += nums[j];
                res = Math.max(res, sum);
            }
        }
        return res; 
    }
    public static int calculateSum(int[] nums ,int i , int j){
        int sum = 0 ; 
        for(int k =i ; k<=j ; k++ ) sum += nums[k];
        return sum ; 
    }
}