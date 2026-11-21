/*
 * 704. Binary Search  [Easy]
 * https://leetcode.com/problems/binary-search/
 * Topics: Array, Binary Search
 *
 * Problem:     Search a sorted array of distinct integers for target and return its index,
 *              or -1. Must be O(log n).
 * Example:     nums=[-1,0,3,5,9,12], target=9 -> 4
 * Constraints: n <= 1e4, sorted, unique
 *
 * Key idea:    Classic template: while (lo <= hi), mid = lo + (hi - lo) / 2 avoids
 *              overflow; move lo or hi past mid.
 *
 * Approach:    Iterative binary search
 * Complexity:  time O(log n), space O(1)
 * Also see:    _2: Recursive binary search
 * Submitted:   2025-09-20 (submission 1776782741, AC)
 */

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length -1; 
        while(left <= right){
            int mid = (right - left) / 2 + left; 
            if(nums[mid] == target) return mid; 
            if(nums[mid] > target){
                right = mid -1; 
            }else{
                left = mid + 1; 
            }
        }
        return -1; 
    }
}