/*
 * 189. Rotate Array  [Medium]
 * https://leetcode.com/problems/rotate-array/
 * Topics: Array, Math, Two Pointers
 *
 * Problem:     Rotate an array to the right by k steps, in place if possible.
 * Example:     [1,2,3,4,5,6,7], k=3 -> [5,6,7,1,2,3,4]
 * Constraints: n <= 1e5, k <= 1e5
 *
 * Key idea:    k %= n, then three reversals: whole array, first k, last n-k. O(1) space.
 *
 * Approach:    Three reversals
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: Temp buffer for the last k elements
 * Submitted:   2023-12-23 (submission 1126771998, AC)
 */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length; 
        if(k >= n) k = k % n; 
        if(k ==0) return; 
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    public static void reverse(int[] nums, int start, int end){
        int i = start, j = end; 
        while(i < j){
            int temp = nums[i]; 
            nums[i] = nums[j]; 
            nums[j] = temp; 

            i ++; 
            j -- ; 
        }
    }
}