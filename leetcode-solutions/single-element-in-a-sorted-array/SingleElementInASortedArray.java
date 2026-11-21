/*
 * 540. Single Element in a Sorted Array  [Medium]
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * Topics: Array, Binary Search
 *
 * Problem:     In a sorted array where every value appears twice except one, find the
 *              single value in O(log n).
 * Example:     [1,1,2,3,3,4,4,8,8] -> 2
 * Constraints: n <= 1e5
 *
 * Key idea:    Before the single element, pairs start at even indices; after it, at odd
 *              ones. At mid, check which side of the pairing you're on and discard that
 *              half.
 *
 * Approach:    Binary search on pair parity
 * Complexity:  time O(log n), space O(1)
 * Submitted:   2023-11-05 (submission 1092159860, AC)
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length; 
        if(n ==1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        int left = 1, right = n-2; 
        while(left <= right){
            int mid = (left + right)/2; 
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
            if((mid%2 ==0 && nums[mid-1] ==nums[mid]) || (mid%2 !=0 && nums[mid+1] ==nums[mid])){
                right = mid -1; 
            } else {
                left = mid +1; 
            }
        }
        return -1; 
    }
}