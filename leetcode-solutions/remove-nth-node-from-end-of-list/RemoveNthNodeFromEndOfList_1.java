/*
 * 19. Remove Nth Node From End of List  [Medium]
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Topics: Linked List, Two Pointers
 *
 * Problem:     Remove the nth node from the end of a linked list.
 * Example:     1->2->3->4->5, n=2 -> 1->2->3->5
 * Constraints: <= 30 nodes
 *
 * Key idea:    One pass: move a fast pointer n steps ahead, then move fast and slow
 *              together until fast reaches the last node; slow is just before the target. A
 *              dummy head handles removing the first node cleanly.
 *
 * Approach:    Two pointers n apart (one pass)
 * Complexity:  time O(L), space O(1)
 * Also see:    _2: Count length, then walk to L - n
 * Submitted:   2025-09-26 (submission 1782944865, AC)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null; 
        ListNode itr1 = head, itr2 = head; 
        for(int i=0; i<n; i++){
            itr2 = itr2.next; 
        }
        while(itr2 != null && itr2.next != null){
            itr1 = itr1.next; 
            itr2 = itr2.next; 
        }
        if(itr2 == null){
            // We need to delete the head node
            return head.next; 
        }else{
            itr1.next = itr1.next.next; 
        }
        return head; 
    }
}