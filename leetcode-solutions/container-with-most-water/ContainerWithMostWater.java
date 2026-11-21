/*
 * 11. Container With Most Water  [Medium]
 * https://leetcode.com/problems/container-with-most-water/
 * Topics: Array, Two Pointers, Greedy
 *
 * Problem:     Given line heights, pick two lines that, with the x-axis, hold the most
 *              water. Return that area.
 * Example:     [1,8,6,2,5,4,8,3,7] -> 49
 * Constraints: n <= 1e5
 *
 * Key idea:    Two pointers from both ends. Area is limited by the shorter line, so move
 *              the shorter one inward: moving the taller one can never give a bigger area.
 *
 * Approach:    Two pointers, move the shorter side
 * Complexity:  time O(n), space O(1)
 * Submitted:   2025-09-12 (submission 1768464882, AC)
 */

class Solution {
    public int maxArea(int[] height) {
        int n = height.length; 
        int left =0, right = n-1; 
        int maxArea = 0; 
        while(left < right){
            int area = (right - left) * Math.min(height[left], height[right]); 
            maxArea = Math.max(area, maxArea); 
            if(height[left] < height[right]){
                left ++; 
            }else{
                right --; 
            }
        }
        return maxArea; 
    }
}
