/*
 * 162. Find Peak Element  [Medium]
 * https://leetcode.com/problems/find-peak-element/
 * Topics: Array, Binary Search
 *
 * Problem:     Return the index of any element strictly greater than its neighbours
 *              (outside the array counts as -infinity). Must be O(log n).
 * Example:     [1,2,1,3,5,6,4] -> 1 or 5
 * Constraints: n <= 1000, adjacent values differ
 *
 * Key idea:    If nums[mid] < nums[mid+1] you are on an uphill slope, so a peak must exist
 *              to the right; otherwise one exists at mid or to the left.
 *
 * Approach:    Binary search following the uphill side
 * Complexity:  time O(log n), space O(1)
 * Submitted:   2025-01-18 (submission 1512794702, AC)
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length; 
        if(n == 1) return 0; 
        if(nums[0] > nums[1]) return 0; 
        if(nums[n-1] > nums[n-2]) return n-1; 
        int left = 1 ,right = n-2; 
        while(left <= right){
            int mid = (right - left ) /2 + left; 
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid; 
            if(nums[mid] >= nums[mid-1] && nums[mid+1] >= nums[mid]){
                left = mid +1; 
            }else{
                right = mid -1; 
            }
        }
        return -1; 
    }
}