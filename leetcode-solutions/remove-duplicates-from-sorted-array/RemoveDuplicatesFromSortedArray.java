/*
 * 26. Remove Duplicates from Sorted Array  [Easy]
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Topics: Array, Two Pointers
 *
 * Problem:     Remove duplicates in place from a sorted array; return the count k of unique
 *              values, which must occupy the first k slots.
 * Example:     [0,0,1,1,1,2,2,3,3,4] -> 5, [0,1,2,3,4,...]
 * Constraints: n <= 3e4
 *
 * Key idea:    Slow pointer i marks the last unique value; fast pointer j scans. When
 *              nums[j] != nums[i], write it to ++i.
 *
 * Approach:    Slow/fast pointers
 * Complexity:  time O(n), space O(1)
 * Submitted:   2023-12-23 (submission 1126355857, AC)
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length; 
        int i = 0; 
        for(int j =1; j<n ; j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j]; 
            }
        }
        return i+1; 
    }
}