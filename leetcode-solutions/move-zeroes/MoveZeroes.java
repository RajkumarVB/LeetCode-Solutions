/*
 * 283. Move Zeroes  [Easy]
 * https://leetcode.com/problems/move-zeroes/
 * Topics: Array, Two Pointers
 *
 * Problem:     Move all zeros to the end in place, keeping the order of the non-zero
 *              elements.
 * Example:     [0,1,0,3,12] -> [1,3,12,0,0]
 * Constraints: n <= 1e4
 *
 * Key idea:    Write pointer: for each non-zero element, swap it into position w and
 *              increment w. Zeros naturally drift to the end.
 *
 * Approach:    Two pointers, swap non-zeros forward
 * Complexity:  time O(n), space O(1)
 * Submitted:   2023-12-23 (submission 1126778353, AC)
 */

class Solution {
    public void moveZeroes(int[] nums) {
        // Non zero pointer points to zero, and there we should fill next non zero element 

        int nonZeroPointer = 0; 
        int i = 0; 
        for(; i<nums.length; i++){
            if(nums[i] != 0){
                swap(nums, i, nonZeroPointer); 
                nonZeroPointer++; 
            }
        }
    }
    public static void swap(int[] nums, int i , int j){
        int temp = nums[i] ; 
        nums[i] = nums[j] ;
        nums[j] = temp ; 
    }
}