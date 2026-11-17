class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length; 
        int result = Integer.MIN_VALUE; 
        int suffix = 1; 
        int prefix = 1; 
        for(int i=0; i<n; i++){
            prefix *= nums[i]; 
            suffix *= nums[n-i-1];

            result = Math.max(result,Math.max(prefix, suffix)); 
            prefix = (prefix ==0) ? 1 : prefix; 
            suffix = (suffix ==0) ? 1 : suffix; 
        }
        return result; 
    }
}