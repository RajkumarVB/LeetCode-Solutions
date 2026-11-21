/*
 * 167. Two Sum II - Input Array Is Sorted  [Medium]
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Topics: Array, Two Pointers, Binary Search
 *
 * Problem:     In a sorted array, return the 1-based indices of two numbers summing to
 *              target, using O(1) extra space.
 * Example:     [2,7,11,15], target=9 -> [1,2]
 * Constraints: n <= 3e4
 *
 * Key idea:    Two pointers from both ends: if the sum is too big move right left, if too
 *              small move left right.
 *
 * Approach:    Two pointers from both ends
 * Complexity:  time O(n), space O(1)
 * Submitted:   2025-09-12 (submission 1768431002, AC)
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i =0, j = numbers.length -1; 
        while(i < j){
            int currentSum = numbers[i] + numbers[j];
            if(currentSum == target){
                return new int[]{i+1, j+1}; 
            }
            if(currentSum > target){
                j--; 
            }else{
                i++; 
            }
        }   
        return new int[]{-1, -1};      
    }
}
