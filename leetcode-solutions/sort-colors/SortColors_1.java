/*
 * 75. Sort Colors  [Medium]
 * https://leetcode.com/problems/sort-colors/
 * Topics: Array, Two Pointers, Sorting, Quicksort, Bubble Sort
 *
 * Problem:     Sort an array of 0s, 1s and 2s in place without a library sort.
 * Example:     [2,0,2,1,1,0] -> [0,0,1,1,2,2]
 * Constraints: n <= 300
 *
 * Key idea:    Dutch national flag: pointers low, mid, high. 0 -> swap to low (low++,
 *              mid++); 1 -> mid++; 2 -> swap to high (high--, don't advance mid, since the
 *              swapped-in value is unchecked).
 *
 * Approach:    Dutch national flag (one pass)
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: Counting sort (two passes)
 * Submitted:   2026-01-22 (submission 1893586089, AC)
 */

class Solution {
    public void sortColors(int[] nums) {
        int low =0, mid = 0, high = nums.length-1; 
        while(mid <= high)  {
            if(nums[mid] ==0){
                swap(nums,mid,low);
                low++;
                mid++; 
            }else if(nums[mid] ==1){
                mid++; 
            }else{
                swap(nums, mid, high);
                high--; 
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }


}