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
 * Approach:    Prefix max + suffix max arrays
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: Two pointers with leftMax/rightMax
 * Submitted:   2025-09-13 (submission 1769444694, AC)
 */

class Solution {
    public int trap(int[] height) {
        int n = height.length; 
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n]; 

        prefixMax[0] = height[0];
        suffixMax[n-1] = height[n-1]; 
        for(int i=1;i<n; i++){
            prefixMax[i] = Math.max(height[i], prefixMax[i-1]);
        }

        for(int i=n-2; i>=0; i--){
            suffixMax[i] = Math.max(height[i], suffixMax[i+1]);
        }


        // compute the water which can be stored at each height 
        int totalWaterTrapped = 0; 
        for(int i=1; i<n-1; i++){
            int waterTrapped = Math.min(prefixMax[i], suffixMax[i]) - height[i]; 
            if(waterTrapped < 0 ){
                waterTrapped = 0; 
            }
            totalWaterTrapped += waterTrapped; 
        }
        return totalWaterTrapped ; 
    }
}
