/*
 * 239. Sliding Window Maximum  [Hard]
 * https://leetcode.com/problems/sliding-window-maximum/
 * Topics: Array, Queue, Sliding Window, Heap (Priority Queue), Monotonic Queue, Range
 *         Minimum/Maximum Query
 *
 * Problem:     Return the maximum of each window of size k as it slides across the array.
 * Example:     [1,3,-1,-3,5,3,6,7], k=3 -> [3,3,5,5,6,7]
 * Constraints: n <= 1e5
 *
 * Key idea:    Monotonic deque of indices with decreasing values. Pop from the back while
 *              the new value is >= the back; drop the front if it's out of the window. The
 *              front is always the window max.
 *
 * Approach:    Monotonic decreasing deque of indices
 * Complexity:  time O(n), space O(k)
 * Submitted:   2025-09-16 (submission 1773028589, AC)
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length; 
        int left =0, right = 0; 
        LinkedList<Integer> deque = new LinkedList<>(); 
        int[] result = new int[n-k+1];
        while(right < n){
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[right]){
                deque.removeLast(); 
            }
            deque.addLast(right); 
            if(deque.getFirst() < left){
                deque.removeFirst(); 
            }
            
            if(right >= k-1){
                result[left] = nums[deque.getFirst()]; 
                left ++; 
            }
            right ++; 
        }
        return result;
    }
}