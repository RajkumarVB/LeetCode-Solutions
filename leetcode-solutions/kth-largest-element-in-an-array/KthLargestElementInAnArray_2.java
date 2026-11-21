/*
 * 215. Kth Largest Element in an Array  [Medium]
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Topics: Array, Divide and Conquer, Sorting, Heap (Priority Queue), Quickselect
 *
 * Problem:     Return the kth largest element of an unsorted array (not the kth distinct).
 * Example:     [3,2,1,5,6,4], k=2 -> 5
 * Constraints: n <= 1e5
 *
 * Key idea:    Size-k min-heap: O(n log k). A max-heap of everything and k pops is O(n + k
 *              log n). Quickselect averages O(n).
 *
 * Approach:    Max-heap of all, poll k times
 * Complexity:  time O(n log n), space O(n)
 * Also see:    _1: Size-k min-heap
 * Submitted:   2024-02-20 (submission 1180177513, AC)
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((ele1, ele2) -> ele2 - ele1); 
        for(int num : nums){
            pq.offer(num);
        }
        for(int i=0; i<k-1; i++) pq.poll(); 
        return pq.poll(); 
    }
}