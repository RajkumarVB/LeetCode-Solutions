/*
 * 33. Search in Rotated Sorted Array  [Medium]
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Topics: Array, Binary Search
 *
 * Problem:     Search a rotated sorted array of distinct values for target in O(log n).
 * Example:     [4,5,6,7,0,1,2], target=0 -> 4
 * Constraints: n <= 5000
 *
 * Key idea:    One half around mid is always sorted. Check whether target lies inside the
 *              sorted half's range; if so search there, else search the other half.
 *
 * Approach:    Binary search choosing the sorted half
 * Complexity:  time O(log n), space O(1)
 * Submitted:   2025-09-23 (submission 1780415465, AC)
 */

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length; 
        int left = 0, right = n-1; 
        while(left <= right){
            int mid = (right - left)/ 2 + left; 
            if(nums[mid] == target) return mid; 
            if(nums[left] <= nums[mid]){
                // left half is sorted or left and mid point to same element 
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid -1; 
                }else{
                    left = mid +1; 
                }
            }else{
                // right half is sorted. 
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