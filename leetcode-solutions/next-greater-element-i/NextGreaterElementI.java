/*
 * 496. Next Greater Element I  [Easy]
 * https://leetcode.com/problems/next-greater-element-i/
 * Topics: Array, Hash Table, Stack, Monotonic Stack
 *
 * Problem:     For each value in nums1 (a subset of nums2), find the first greater value to
 *              its right in nums2, or -1.
 * Example:     nums1=[4,1,2], nums2=[1,3,4,2] -> [-1,3,-1]
 * Constraints: lengths <= 1000, unique values
 *
 * Key idea:    Compute next-greater for all of nums2 with a monotonic stack (right to
 *              left), store it in a map value -> next greater, then look up each nums1
 *              value.
 *
 * Approach:    Monotonic stack + value->index map
 * Complexity:  time O(n + m), space O(n)
 * Submitted:   2025-09-19 (submission 1776307967, AC)
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> indexPosition = new HashMap<>(); 
        int[] result = new int[nums1.length]; 
        int[] nextGreaterElement = nextGreaterElement(nums2); 
        for(int i=0; i<nums2.length; i++){
            indexPosition.put(nums2[i], i); 
        }

        for(int i=0; i<nums1.length; i++){
            result[i] = nextGreaterElement[indexPosition.get(nums1[i])];
        }
        return result; 
    }
    private int[] nextGreaterElement(int[] nums){
        int n = nums.length; 
        LinkedList<Integer> stack = new LinkedList<>(); 
        int[] result = new int[n]; 
        Arrays.fill(result, -1); 
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[i] >= stack.getLast()){
                stack.removeLast(); 
            }
            if(!stack.isEmpty()){
                result[i] = stack.getLast(); 
            }
            stack.addLast(nums[i]); 
        }
        return result; 
    }
}