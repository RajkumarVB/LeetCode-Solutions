class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurence(nums, target);
        if(first ==-1) return new int[]{-1,-1};
        int last = lastOccurence(nums, target);
        return new int[]{first,last};
    }
    
    public static int firstOccurence(int[] nums, int target){
        int n = nums.length; 
        int left =0, right = n-1; 
        int ans = -1; 
        while(left <= right){
            int mid = (left + right)/2; 
            if(nums[mid] == target){
                ans = mid; 
                right = mid -1; 
            } else if (nums[mid] > target){
                right = mid -1; 
            } else {
                left = mid +1; 
            }
        }
        return ans; 
    }
    
    public static int lastOccurence(int[] nums, int target){
        int n = nums.length; 
        int left =0, right = n-1; 
        int ans = -1; 
        while(left <= right){
            int mid = (left + right)/2; 
            if(nums[mid] == target){
                ans = mid; 
                left = mid +1; 
            } else if (nums[mid] > target){
                right = mid -1; 
            } else {
                left = mid +1; 
            }
        }
        return ans; 
    }
}