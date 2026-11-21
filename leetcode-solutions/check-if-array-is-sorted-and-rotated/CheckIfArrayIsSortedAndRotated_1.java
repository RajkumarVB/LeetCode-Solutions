/*
 * 1752. Check if Array Is Sorted and Rotated  [Easy]
 * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 * Topics: Array
 *
 * Problem:     Return true if the array is a non-decreasing array rotated by some amount
 *              (possibly zero).
 * Example:     [3,4,5,1,2] -> true; [2,1,3,4] -> false
 * Constraints: n <= 100
 *
 * Key idea:    Count the 'drops' where nums[i] > nums[(i+1) % n] (circularly). A sorted-
 *              and-rotated array has at most one drop.
 *
 * Approach:    Count circular drops (<= 1)
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: Brute force: try every rotation
 * Submitted:   2023-12-23 (submission 1126490140, AC)
 */

class Solution {
    public boolean check(int[] nums) {
        int falseCount = 0; 
        int n = nums.length; 
        for(int i=0; i<n; i++){
            if(nums[i] > nums[(i+1) % n ] ) falseCount ++; 
            if(falseCount > 1) return false; 
        }
        return true;
    }
}