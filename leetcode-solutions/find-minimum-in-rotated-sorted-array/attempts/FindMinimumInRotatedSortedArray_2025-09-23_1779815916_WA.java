class Solution {
    public int findMin(int[] nums) {
        int n = nums.length; 
        int left = 0, right = n-1; 
        int min = nums[0]; 
        while(left <=right){
            int mid = (right - left) /2 + left; 
            min = Math.min(min, nums[mid]);
            if(nums[left] < nums[mid]){
                min = Math.min(min, nums[left]); 
                left = mid + 1; 
            }else{
                right = mid - 1; 
            }
        }
        return min; 
    }
}
// 0 1 2 3 4 
// 3 4 5 1 2 


// 0 1
// 2 1 
