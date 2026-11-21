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
 * Approach:    Counting sort (two passes)
 * Complexity:  time O(n), space O(1)
 * Also see:    _1: Dutch national flag (one pass)
 * Submitted:   2023-08-22 (submission 1028237926, AC)
 */

class Solution {
    public void sortColors(int[] nums) {
        int zeroes = 0, ones = 0 , twos = 0 ;
        for(int element : nums){
            if(element ==0) zeroes ++;
            else if(element ==1) ones ++;
            else twos ++; 
        }
        int i = 0; 
        for(int j = 0; j<zeroes; j++){
            nums[i] = 0 ;
            i++;
        }
        for(int j = 0; j<ones; j++){
            nums[i] = 1 ;
            i++;
        }
        for(int j = 0; j<twos; j++){
            nums[i] = 2 ;
            i++;
        }
    }
}