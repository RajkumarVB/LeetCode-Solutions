/*
 * 31. Next Permutation  [Medium]
 * https://leetcode.com/problems/next-permutation/
 * Topics: Array, Two Pointers
 *
 * Problem:     Rearrange the array into the next lexicographically greater permutation, in
 *              place (wrap to the smallest if it's the last).
 * Example:     [1,2,3] -> [1,3,2]; [3,2,1] -> [1,2,3]
 * Constraints: n <= 100
 *
 * Key idea:    1) From the right, find the first i with nums[i] < nums[i+1] (the pivot). 2)
 *              From the right, find the first element larger than nums[i] and swap them. 3)
 *              Reverse the suffix after i. If there's no pivot, reverse the whole array.
 *
 * Approach:    Pivot, swap with successor, reverse suffix
 * Complexity:  time O(n), space O(1)
 * Submitted:   2026-01-24 (submission 1895267602, AC)
 */

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length; 
        int breakingPoint = -1; 
        
        for(int i=n-2; i>=0 ;i--){
            if(nums[i] < nums[i+1]){
                breakingPoint = i ; 
                break; 
            }
        }
        
        if(breakingPoint == -1){
            // arrays is sorted in descending order 
            reverse(nums, 0 , n-1);
            return; 
        }

        // you found the breakingPoint 
        for(int i=n-1; i>breakingPoint; i--){
            if(nums[i] > nums[breakingPoint]){
                swap(nums, i, breakingPoint);
                break; 
            }
        }

        reverse(nums, breakingPoint+1, n-1); 
    }

    private void reverse(int[] nums, int i, int j){
        // swap in that range only 
        // assuming i and j are in bounds

        int left = i; 
        int right = j; 
        while(left < right){
            swap(nums, left, right);
            left ++ ;
            right --; 
        }

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }
}