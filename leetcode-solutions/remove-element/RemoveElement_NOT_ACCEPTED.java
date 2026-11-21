/*
 * 27. Remove Element  [Easy]
 * https://leetcode.com/problems/remove-element/
 * Topics: Array, Two Pointers
 *
 * Problem:     Remove every occurrence of val in place and return how many elements remain;
 *              they must occupy the first k slots (any order).
 * Example:     nums=[3,2,2,3], val=3 -> 2, [2,2,...]
 * Constraints: n <= 100
 *
 * Key idea:    Write pointer k: for each element != val, copy it to nums[k++]. Return k.
 *
 * STATUS:      NOT ACCEPTED - this is your latest attempt. Earlier attempts are in
 *              attempts/.
 * Submitted:   2026-09-03 (submission 2129852200, WA)
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length; 
        int i=0, j=n-1; 

        int count = 0; 
        while(j >=0 ){
            if(nums[j] == val){
                count ++; 
                j--; 
            }else{
                break;
            }
        }
        while(i <= j){
            if(nums[i] == val){
                count++; 
                swap(nums, i, j);
                j--;
            }
            i++; 
        }
        return n - count; 
    }

    private void swap(int[] nums, int i, int j){
        int temp; 
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }
}