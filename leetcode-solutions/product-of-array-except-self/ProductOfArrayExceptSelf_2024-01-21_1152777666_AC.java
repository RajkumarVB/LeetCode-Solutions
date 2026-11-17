class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 
        int[] result = new int[n]; 
        result[n-1] = 1; 

        for(int i=n-2; i>=0; i--){
            result[i] = nums[i+1] * result[i+1];
        }
        int prefix = 1; 
        for(int i=1;i<n;i++){
            prefix = nums[i-1] * prefix; 
            result[i] = prefix * result[i];
        }
        return result; 
    }
}