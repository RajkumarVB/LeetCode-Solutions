/*
 * 703. Kth Largest Element in a Stream  [Easy]
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Topics: Tree, Design, Binary Search Tree, Heap (Priority Queue), Binary Tree, Data Stream
 *
 * Problem:     Design a class that, after each added number, returns the kth largest number
 *              seen so far.
 * Example:     k=3, nums=[4,5,8,2]; add 3 -> 4, add 5 -> 5, add 10 -> 5
 * Constraints: <= 1e4 calls
 *
 * Key idea:    Keep a min-heap of size k: it holds the k largest values and the top is the
 *              kth largest. Pop whenever the size exceeds k.
 *
 * Approach:    Size-k min-heap
 * Complexity:  time O(log k) per add, space O(k)
 * Submitted:   2024-02-19 (submission 1180155569, AC)
 */

class KthLargest {
    private PriorityQueue<Integer> pq; 
    private int k; 
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>(); 
        this.k = k; 
        for(int data : nums) add(data); 
    }
    
    public int add(int val) {
        pq.offer(val); 
        if(pq.size() > k ){
            pq.poll(); 
        }
        return pq.peek(); 
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */