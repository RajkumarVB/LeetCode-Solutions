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
 * Approach:    Size-k min-heap
 * Complexity:  time O(n log k), space O(k)
 * Also see:    _2: Max-heap of all, poll k times
 * Submitted:   2026-01-19 (submission 1890096775, AC)
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Maintain a min-heap of size k
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int ele : nums){
            pq.add(ele);

            while(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}