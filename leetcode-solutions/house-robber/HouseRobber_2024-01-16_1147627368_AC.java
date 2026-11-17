class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        if(n ==1) return nums[0]; 
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