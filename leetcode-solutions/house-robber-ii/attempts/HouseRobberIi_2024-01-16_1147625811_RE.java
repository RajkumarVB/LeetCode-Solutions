class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        int[] nums1 = Arrays.copyOfRange(nums,0,n-1);
        int[] nums2 = Arrays.copyOfRange(nums,1,n);
        return Math.max(solve(nums1),solve(nums2)); 
    }
    public int solve(int[] nums){
        int n = nums.length; 
		int curr =0 ; 		
		int next2 = 0; 
		int next = nums[n-1];

		for(int i = n-2; i>=0; i--){
			int chooseResult = nums[i] + next2;
			int notChoose = next; 
			curr = Math.max(chooseResult, notChoose); 
			next2 = next; 
			next = curr; 
		}

		return next; 
    }
}