class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length; 
        int left = 0, right = n-1; 
        while(left <= right){
            int mid = left + (right - left)/2;

            if(target == nums[mid]){
               return mid; 
            } else {
                if((left == right) && mid == 0 || mid == n-1) return -1; 
                if(target < nums[mid]){
                    if(nums[mid+1] < nums[mid] && nums[mid+1] >= target){
                        left = mid + 1; 
                    } else{
                        right = mid -1; 
                    }
                } else{
                    if(nums[mid-1] > nums[mid] && nums[mid-1] >= target){
                        right = mid -1; 
                    } else{
                        left = mid + 1; 
                    }
                }
            } 
        }
        return -1; 
    }
}