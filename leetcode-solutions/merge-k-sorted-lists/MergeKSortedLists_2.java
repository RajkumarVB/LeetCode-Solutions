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
 * Approach:    Merge lists one by one
 * Complexity:  time O(N * k), space O(1)
 * Also see:    _1: Min-heap of current heads
 * Submitted:   2026-01-20 (submission 1890291886, AC)
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
        if(lists == null || lists.length == 0) return null; 
        ListNode head = lists[0];
        for(int i=1; i<lists.length; i++){
            head = mergeTwoSortedLists(head, lists[i]);
        }
        return head; 
    }

    private ListNode mergeTwoSortedLists(ListNode node1, ListNode node2){
        if(node1 ==null) return node2; 
        if(node2 ==null) return node1; 

        ListNode dummyNode = new ListNode(-1);
        ListNode resultItr = dummyNode; 


        ListNode itr1 = node1, itr2 = node2; 

        while(itr1 != null && itr2 != null){
            if(itr1.val < itr2.val){
                resultItr.next = itr1; 
                itr1 = itr1.next; 
            }else{
                resultItr.next = itr2; 
                itr2 = itr2.next; 
            }
            resultItr = resultItr.next; 
        }
        if(itr1 != null){
            resultItr.next = itr1; 
        }

        if(itr2 != null){
            resultItr.next = itr2; 
        }
        return dummyNode.next; 
    }
}