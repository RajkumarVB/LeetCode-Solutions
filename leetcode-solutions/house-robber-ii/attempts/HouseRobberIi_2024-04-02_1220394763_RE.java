class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        int[] nums1 = Arrays.copyOfRange(nums,0,n-1);
        int[] nums2 = Arrays.copyOfRange(nums,1,n);
        return Math.max(maxMoney(nums1),maxMoney(nums2)); 
    }
    public int maxMoney(int[] nums) {
        int n = nums.length; 
        int[] dp = new int[n]; 
        for(int i=n-1; i>=0 ;i--){
            int path1 = nums[i], path2 =0; 
            if(i+2 < n) path1 += dp[i+2]; 
            if(i+1 < n) path2 = dp[i+1]; 
            dp[i] = Math.max(path1,path2); 
        }
        return dp[0];
    }
}