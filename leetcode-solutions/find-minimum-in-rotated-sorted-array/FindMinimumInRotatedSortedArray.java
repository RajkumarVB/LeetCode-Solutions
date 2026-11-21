/*
 * 153. Find Minimum in Rotated Sorted Array  [Medium]
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Topics: Array, Binary Search
 *
 * Problem:     A sorted array of unique values was rotated. Find its minimum in O(log n).
 * Example:     [3,4,5,1,2] -> 1
 * Constraints: n <= 5000, unique
 *
 * Key idea:    At each step one half is sorted. If nums[lo] <= nums[mid], the left half is
 *              sorted: its minimum is nums[lo], so record it and search right. Otherwise
 *              the minimum is in the left part including mid.
 *
 * Approach:    Binary search on the sorted half, early exit if range sorted
 * Complexity:  time O(log n), space O(1)
 * Submitted:   2025-09-23 (submission 1780407733, AC)
 */

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length; 
        int left =0 , right = n-1; 
        int min = nums[0];
        while(left <= right){
            if(nums[left] < nums[right]){
                min = Math.min(min, nums[left]); 
                break; 
            }
            int mid = (right - left) / 2 + left; 
            min = Math.min(min, nums[mid]); 
            if(nums[left] <= nums[mid]){
                min = Math.min(min, nums[left]); 
                left = mid + 1; 
            }else{
                right = mid -1; 
            }
        }
        return min; 
    }
}