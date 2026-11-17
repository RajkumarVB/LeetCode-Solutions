class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length; 
        if(nums[0] == target) return 0; 
        if(nums[n-1] == target) return n-1; 
        int left =0, right = n-1; 
        while(left <= right){
            int mid = (right - left ) / 2 + left; 
            if(nums[mid] == target) return mid; 
            if(nums[left] < nums[mid]){
                // left half is sorted
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid -1; 
                }else{
                    left = mid + 1; 
                }
            }else{
                // right half is sorted
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid + 1; 
                }else{
                    right = mid -1; 
                }
            }
        }
        return -1; 
    }
}



