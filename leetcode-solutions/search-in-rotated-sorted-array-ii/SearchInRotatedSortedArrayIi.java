/*
 * 81. Search in Rotated Sorted Array II  [Medium]
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Topics: Array, Binary Search
 *
 * Problem:     Same as Search in Rotated Sorted Array but with duplicates; return true or
 *              false.
 * Example:     [2,5,6,0,0,1,2], target=0 -> true
 * Constraints: n <= 5000
 *
 * Key idea:    When nums[lo] == nums[mid] == nums[hi] you can't tell which half is sorted,
 *              so shrink both ends by one. The worst case degrades to O(n).
 *
 * Approach:    Rotated search + shrink on equal ends
 * Complexity:  time O(log n) avg, O(n) worst, space O(1)
 * Submitted:   2025-09-23 (submission 1780429329, AC)
 */

class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length; 
        int left =0, right = n-1; 
        while(left <= right){
            int mid = (right - left) / 2 + left; 
            if(nums[mid] == target) return true; 
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left ++; 
                right --; 
                continue; 
            }
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid -1; 
                }else{
                    left = mid + 1; 
                }
            }else{
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid + 1; 
                }else{
                    right = mid -1; 
                }
            }
        }
        return false; 
    }
}