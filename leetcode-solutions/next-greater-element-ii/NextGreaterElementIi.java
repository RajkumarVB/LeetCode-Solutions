/*
 * 503. Next Greater Element II  [Medium]
 * https://leetcode.com/problems/next-greater-element-ii/
 * Topics: Array, Stack, Monotonic Stack
 *
 * Problem:     Next greater element for every position in a circular array.
 * Example:     [1,2,1] -> [2,-1,2]
 * Constraints: n <= 1e4
 *
 * Key idea:    Simulate two copies of the array: iterate i from 2n-1 down to 0 using nums[i
 *              % n] with a monotonic stack, and only record answers when i < n.
 *
 * Approach:    Monotonic stack over 2n indices
 * Complexity:  time O(n), space O(n)
 * Submitted:   2025-09-19 (submission 1776318758, AC)
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length; 
        LinkedList<Integer> stack = new LinkedList<>();
        int[] result = new int[n]; 
        for(int i=2*n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[i%n] >= stack.getLast()){
                stack.removeLast(); 
            }
            if(i <= n-1){
                if(!stack.isEmpty()){
                result[i] = stack.getLast();
                }else{
                    result[i] = -1; 
                }
            }
            
            stack.addLast(nums[i%n]);
        }
        return result; 
    }
}