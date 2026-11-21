/*
 * 23. Merge k Sorted Lists  [Hard]
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Topics: Linked List, Divide and Conquer, Heap (Priority Queue), Merge Sort, Tournament
 *         Sort
 *
 * Problem:     Merge k sorted linked lists into one sorted list.
 * Example:     [[1,4,5],[1,3,4],[2,6]] -> [1,1,2,3,4,4,5,6]
 * Constraints: k <= 1e4, total nodes <= 1e4
 *
 * Key idea:    Min-heap of the k list heads: pop the smallest, append it, push its next
 *              node. Divide and conquer (merge lists in pairs) gives the same O(N log k).
 *
 * Approach:    Min-heap of current heads
 * Complexity:  time O(N log k), space O(k)
 * Also see:    _2: Merge lists one by one
 * Submitted:   2026-01-20 (submission 1890287051, AC)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1, node2) -> node1.val - node2.val); 
        
        for(ListNode node : lists){
            if(node != null) pq.offer(node); 
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode resultItr = dummyNode; 
        
        while(!pq.isEmpty()){
            ListNode node = pq.poll(); 
            resultItr.next = node; 
            resultItr = resultItr.next;

            if(node.next != null){
                pq.offer(node.next);
            }
        }

        return dummyNode.next; 
    }
}