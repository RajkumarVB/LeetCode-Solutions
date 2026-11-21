/*
 * 213. House Robber II  [Medium]
 * https://leetcode.com/problems/house-robber-ii/
 * Topics: Array, Dynamic Programming
 *
 * Problem:     House Robber where the houses form a circle, so the first and last are
 *              adjacent.
 * Example:     [2,3,2] -> 3
 * Constraints: n <= 100
 *
 * Key idea:    You can't take both the first and last house, so answer =
 *              max(rob(nums[0..n-2]), rob(nums[1..n-1])) using the linear House Robber.
 *
 * Approach:    Two linear runs, O(1)-space DP
 * Complexity:  time O(n), space O(n) for copies
 * Submitted:   2024-01-16 (submission 1147626442, AC)
 */

class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        if(n == 1) return nums[0]; 
        int[] nums1 = Arrays.copyOfRange(nums,0,n-1);
        int[] nums2 = Arrays.copyOfRange(nums,1,n);
        return Math.max(solve(nums1),solve(nums2)); 
    }
    public int solve(int[] nums){
        int n = nums.length; 
		int curr =0 ; 		
		int next2 = 0; 
		int next = nums[n-1];

		for(int i = n-2; i>=0; i--){
			int chooseResult = nums[i] + next2;
			int notChoose = next; 
			curr = Math.max(chooseResult, notChoose); 
			next2 = next; 
			next = curr; 
		}

		return next; 
    }
}