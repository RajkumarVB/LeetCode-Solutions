/*
 * 35. Search Insert Position  [Easy]
 * https://leetcode.com/problems/search-insert-position/
 * Topics: Array, Binary Search
 *
 * Problem:     Return target's index in a sorted array, or the index where it would be
 *              inserted.
 * Example:     [1,3,5,6], 2 -> 1
 * Constraints: n <= 1e4
 *
 * Key idea:    This is the lower bound: the first index with nums[i] >= target. Binary
 *              search, recording mid whenever nums[mid] >= target.
 *
 * Approach:    Lower-bound binary search
 * Complexity:  time O(log n), space O(1)
 * Submitted:   2023-10-31 (submission 1088007762, AC)
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length; 
        int left = 0, right = n-1; 
        int ans = n; 
        while(left <= right){
            int mid = (left + right)/2; 
            if(nums[mid] >= target){
                ans = mid; 
                right = mid -1; 
            } else {
                left = mid +1; 
            }
        }
        return ans; 
    }
}