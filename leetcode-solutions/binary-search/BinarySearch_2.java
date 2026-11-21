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
 * Approach:    Recursive binary search
 * Complexity:  time O(log n), space O(log n) stack
 * Also see:    _1: Iterative binary search
 * Submitted:   2023-10-24 (submission 1082976045, AC)
 */

class Solution {
    public int search(int[] nums, int target) {
        return recursiveBinarySearch(nums,0,nums.length-1, target);
    }
    public int recursiveBinarySearch(int[] nums, int left, int right, int target){
        if(left > right) return -1; 
        int mid = (left +right)/2; 
        if(target == nums[mid]){
            return mid;
        } else if (target > nums[mid]) {
            return recursiveBinarySearch(nums,mid+1,right,target);
        } 
        return recursiveBinarySearch(nums,left,mid-1,target);
    }
}