class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n]; 
        prefixProduct[0] = nums[0]; 
        suffixProduct[n-1] = nums[n-1]; 
        for(int i=1; i<n; i++){
            prefixProduct[i] = prefixProduct[i-1] * nums[i]; 
            suffixProduct[n-i-1] = suffixProduct[n-i] * nums[n-i-1]; 
        }
        int[] ans = new int[n];
        ans[0] = suffixProduct[1]; 
        ans[n-1] = prefixProduct[n-2];
        for(int i=1; i<n-1; i++){
            ans[i] = prefixProduct[i-1] * suffixProduct[i+1];
        }
        return ans; 
    }
}
