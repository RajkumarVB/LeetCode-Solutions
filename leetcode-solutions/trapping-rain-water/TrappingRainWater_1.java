/*
 * 42. Trapping Rain Water  [Hard]
 * https://leetcode.com/problems/trapping-rain-water/
 * Topics: Array, Two Pointers, Dynamic Programming, Stack, Monotonic Stack
 *
 * Problem:     Given bar heights, compute how much rain water is trapped between them.
 * Example:     [0,1,0,2,1,0,1,3,2,1,2,1] -> 6
 * Constraints: n <= 2e4
 *
 * Key idea:    Water at i = min(maxLeft[i], maxRight[i]) - h[i]. Prefix/suffix max arrays
 *              give O(n) space. Two pointers give O(1): always move the side with the
 *              smaller max, since that max bounds the water there.
 *
 * Approach:    Two pointers with leftMax/rightMax
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: Prefix max + suffix max arrays
 * Submitted:   2026-01-21 (submission 1892394488, AC)
 */

class Solution {
    public int trap(int[] height) {
        int n = height.length; 

        if(n <= 2) return 0; 

        int left = 0, right = n-1, leftMax = height[0], rightMax = height[n-1]; 
        int waterTrapped = 0; 

        while(left < right){
            if(height[left] <= height[right]){

                // since we're concerned with min of leftmax, rightmax
                left ++; 
                int water = (leftMax - height[left] > 0) ? (leftMax - height[left]) : 0; 
                waterTrapped += water; 
                leftMax = Math.max(leftMax, height[left]);
            }else{
                right --; 
                // since we are coming from right, we'll be pretty sure that rightMax is min(leftMax, rightMax)
                int water = (rightMax - height[right] > 0) ? (rightMax - height[right]) : 0; 
                waterTrapped += water; 
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return waterTrapped; 
    }
}