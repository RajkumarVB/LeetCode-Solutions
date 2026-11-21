/*
 * 287. Find the Duplicate Number  [Medium]
 * https://leetcode.com/problems/find-the-duplicate-number/
 * Topics: Array, Two Pointers, Binary Search, Bit Manipulation, Pigeonhole Principle,
 *         Floyd's Cycle Finding Algorithm
 *
 * Problem:     An array of n+1 integers in [1, n] has exactly one repeated value. Find it
 *              without modifying the array and with O(1) extra space.
 * Example:     [1,3,4,2,2] -> 2
 * Constraints: n <= 1e5
 *
 * Key idea:    Treat i -> nums[i] as a linked list; the duplicate is where a cycle starts.
 *              Floyd: slow/fast meet inside the cycle, then reset one pointer to the start
 *              and move both one step until they meet.
 *
 * Approach:    Floyd's cycle detection (tortoise and hare)
 * Complexity:  time O(n), space O(1)
 * Submitted:   2025-10-08 (submission 1795478060, AC)
 */

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0; 

        do{
            slow = nums[slow]; 
            fast = nums[nums[fast]]; 
        }while(slow != fast); 

        int slow2 = 0; 
        do{
            slow = nums[slow]; 
            slow2 = nums[slow2];
        }while(slow != slow2); 
        
        return slow; 
    }
}