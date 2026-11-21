/*
 * 148. Sort List  [Medium]
 * https://leetcode.com/problems/sort-list/
 * Topics: Linked List, Two Pointers, Divide and Conquer, Sorting, Merge Sort
 *
 * Problem:     Sort a linked list in O(n log n).
 * Example:     4->2->1->3 -> 1->2->3->4
 * Constraints: <= 5e4 nodes
 *
 * Key idea:    Merge sort: split at the middle with slow/fast (fast starts at head.next so
 *              the split is balanced), sort both halves recursively, and merge the two
 *              sorted lists.
 *
 * Approach:    Top-down merge sort
 * Complexity:  time O(n log n), space O(log n) stack
 * Submitted:   2024-01-06 (submission 1138191406, AC)
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head; 
        // At this point, we have atleast two nodes 
        ListNode middle = findMiddle(head);
        ListNode leftHead = head; 
        ListNode rightHead = middle.next;
        middle.next = null;  

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return mergeSortedList(leftHead,rightHead); 
    }

    public ListNode findMiddle(ListNode head){
        if(head == null || head.next == null) return head; 
        ListNode slow = head; 
        ListNode fast = head.next; 
        while(fast != null && fast.next != null){
            fast = fast.next.next; 
            slow = slow.next; 
        }
        return slow; 
    }

    public ListNode mergeSortedList(ListNode head1, ListNode head2){
        ListNode head = new ListNode(-1); 
        ListNode tail = head; 
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                tail.next = head1; 
                head1 = head1.next; 
            } else {
                tail.next = head2; 
                head2 = head2.next; 
            }
            tail = tail.next; 
        }
        tail.next = (head1 != null) ? head1 : head2 ; 
        return head.next; 
    }
}