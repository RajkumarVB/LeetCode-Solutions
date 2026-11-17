class Solution {
    private int[] nums; 
    int target; 
    public int[] searchRange(int[] nums, int target) {
        this.nums = nums; 
        this.target = target; 
        int[] result = new int[2]; 
        result[0] = firstPosition();
        result[1] = lastPosition(); 
        return result;

    }

    public int firstPosition(){
        int n= nums.length; 
        int left = 0, right = n-1; 
        int result = -1; 
        while(left <= right){
            int mid = left + (right - left)/2; 
            if(nums[mid] == target) result = mid; 
            if(target <= nums[mid]){
                right = mid -1; 
            } else{
                left = mid +1; 
            }
        }
        return result; 
    }

    public int lastPosition(){
        int n = nums.length; 
        int left = 0, right = n-1; 
        int result = -1; 
        while(left <= right){
            int mid = left + (right - left)/2; 
            if(nums[mid] == target) result = mid; 
            if(target >= nums[mid]){
                left = mid +1;
            } else{
                right = mid -1; 
            }
        }
        return result; 
    }

}