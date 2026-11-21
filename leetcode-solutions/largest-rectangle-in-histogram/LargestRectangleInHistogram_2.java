/*
 * 84. Largest Rectangle in Histogram  [Hard]
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Topics: Array, Stack, Monotonic Stack, Range Minimum/Maximum Query
 *
 * Problem:     Given bar heights (width 1 each), return the area of the largest rectangle
 *              in the histogram.
 * Example:     [2,1,5,6,2,3] -> 10
 * Constraints: n <= 1e5
 *
 * Key idea:    Each bar's best rectangle extends to the previous and next smaller bars:
 *              area = h[i] * (nextSmaller - prevSmaller - 1). Find both with monotonic
 *              stacks, or in one pass: when a bar is popped, the current index is its next
 *              smaller and the new top is its previous smaller.
 *
 * Approach:    Previous/next smaller arrays via two stacks
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: One-pass monotonic stack (compute on pop)
 * Submitted:   2025-09-20 (submission 1776402713, AC)
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length; 
        int result = Integer.MIN_VALUE; 

        int[] nextSmallerElementToR = nextSmallerElement(heights); 
        int[] nextSmallerElementToL = nextSmallerElementToL(heights); 

        // System.out.println("nextSmallerElementToR " + Arrays.toString(nextSmallerElementToR));
        // System.out.println("nextSmallerElementToL " + Arrays.toString(nextSmallerElementToL));

        for(int i=0; i<n; i++){
            int area = (nextSmallerElementToR[i] - nextSmallerElementToL[i] - 1) *  heights[i];
            result = Math.max(area, result);
        }
        return result; 
    }

    private int[] nextSmallerElement(int[] nums){
        int n = nums.length; 
        int[] result = new int[n]; 
        LinkedList<Integer> stack = new LinkedList<>(); 
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[i] <= nums[stack.getLast()]){
                stack.removeLast();
            }
            if(!stack.isEmpty()){
                result[i] = stack.getLast();
            }else{
                result[i] = n;
            }
            stack.addLast(i); 
        }
        return result; 
    }

    private int[] nextSmallerElementToL(int[] nums){
        int n = nums.length; 
        int[] result = new int[n]; 
        LinkedList<Integer> stack = new LinkedList<>(); 
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && nums[i] <= nums[stack.getLast()]){
                stack.removeLast();
            }
            if(!stack.isEmpty()){
                result[i] = stack.getLast();
            }else{
                result[i] = -1;
            }
            stack.addLast(i); 
        }
        return result; 
    }
}

