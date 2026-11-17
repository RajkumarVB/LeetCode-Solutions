class Solution {
    public int findDuplicate(int[] nums) {
        int ans = 0; 
        int n = nums.length; 
        for(int i=0; i<n; i++){
            ans ^= i ^ nums[i]; 
        }
        return ans; 
    }
}