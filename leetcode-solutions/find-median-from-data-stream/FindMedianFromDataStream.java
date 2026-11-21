/*
 * 295. Find Median from Data Stream  [Hard]
 * https://leetcode.com/problems/find-median-from-data-stream/
 * Topics: Two Pointers, Design, Sorting, Heap (Priority Queue), Data Stream
 *
 * Problem:     Design a structure that accepts numbers one at a time and can return the
 *              median of everything added so far.
 * Example:     add 1, add 2 -> 1.5; add 3 -> 2.0
 * Constraints: <= 5e4 calls
 *
 * Key idea:    Two heaps: a max-heap for the smaller half and a min-heap for the larger
 *              half. Keep sizes within 1 and every element of 'small' <= every element of
 *              'large'. The median is at the heap tops.
 *
 * Approach:    Max-heap + min-heap, rebalance on insert
 * Complexity:  time O(log n) add, O(1) median, space O(n)
 * Submitted:   2026-01-21 (submission 1891435116, AC)
 */

class MedianFinder {
    private PriorityQueue<Integer> small; 
    private PriorityQueue<Integer> large; 
    public MedianFinder() {
        small = new PriorityQueue<>((a,b) -> b-a); // max heap
        large = new PriorityQueue<>((a,b) -> a-b); // min heap


    }
    
    public void addNum(int num) {
        small.offer(num);

        // if we need to put some elements to max heap do that
        if(small.size() - large.size() > 1 || (!large.isEmpty() && small.peek() > large.peek())){
            large.offer(small.poll());
        }

        // now large might have more elements than small
        if(large.size() - small.size() > 1){
            small.offer(large.poll());
        }

    }
    
    public double findMedian() {
        if(small.size() == large.size()){
            return ((small.peek() + large.peek()) / 2.0);
        }else if(small.size() > large.size()){
            return (double) small.peek();
        }else{
            return (double) large.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */