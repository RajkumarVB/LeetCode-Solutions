/*
 * 34. Find First and Last Position of Element in Sorted Array  [Medium]
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Topics: Array, Binary Search
 *
 * Problem:     In a sorted array, return the first and last index of target, or [-1,-1].
 *              Must be O(log n).
 * Example:     nums=[5,7,7,8,8,10], target=8 -> [3,4]
 * Constraints: n <= 1e5
 *
 * Key idea:    Run binary search twice. When you hit target, record it and keep searching
 *              left (for first) or right (for last) instead of stopping.
 *
 * Approach:    Two binary searches (lower / upper bound)
 * Complexity:  time O(log n), space O(1)
 * Submitted:   2023-12-31 (submission 1133151570, AC)
 */

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