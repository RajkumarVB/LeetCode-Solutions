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
 * Approach:    One-pass monotonic stack (compute on pop)
 * Complexity:  time O(n), space O(n)
 * Also see:    _2: Previous/next smaller arrays via two stacks
 * Submitted:   2025-09-20 (submission 1776765817, AC)
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length; 
        LinkedList<Integer> stack = new LinkedList<>(); 
        int result = 0; 
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.getLast()]){
                int element = heights[stack.getLast()]; 
                stack.removeLast();
                int previousSmaller = stack.isEmpty() ? -1 : stack.getLast(); 
                int nextSmaller = i; 
                int width = nextSmaller - previousSmaller -1 ; 
                int area = width * element; 
                result = Math.max(area, result); 
            }
            stack.addLast(i); 
        }
        while(!stack.isEmpty()){
            int element = heights[stack.getLast()]; 
            stack.removeLast(); 
            int previousSmaller = stack.isEmpty() ? -1 : stack.getLast(); 
            int nextSmaller = n; 
            int width = nextSmaller - previousSmaller -1 ; 
            int area = width * element; 
            result = Math.max(area, result); 
        }
        return result; 
    }
}