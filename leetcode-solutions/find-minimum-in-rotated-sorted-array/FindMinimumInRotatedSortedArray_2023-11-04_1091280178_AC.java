class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE; 
        int n = nums.length; 
        int left =0 , right = n-1;
        while(left <= right){
            int mid = (left + right)/2 ; 

            // If entire search space is sorted, no need to perform BS. 
            if(nums[left] <= nums[right]){
                ans = Math.min(ans, nums[left]); 
                break; 
            }
            if(nums[left] <= nums[mid]){
                ans = Math.min(ans,nums[left]);
                left = mid +1; 
            } else{
                ans = Math.min(ans,nums[mid]);
                right = mid -1; 
            }
        }
        return ans; 
    }
}