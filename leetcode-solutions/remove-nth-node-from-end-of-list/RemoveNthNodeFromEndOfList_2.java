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
 * Approach:    Count length, then walk to L - n
 * Complexity:  time O(L), space O(1)
 * Also see:    _1: Two pointers n apart (one pass)
 * Submitted:   2024-02-03 (submission 1164429002, AC)
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
        ListNode temp = head; 
        int count =0; 
        while(temp != null){
            count++; 
            temp = temp.next; 
        }
        temp = head; 
        if(n == count) return temp.next; 
        for(int i=1; i<= count-n-1 ; i++) temp = temp.next; 
        temp.next = temp.next.next; 
        return head; 
    }
}

// 1 2 3 4 5 

// 1
// 5 - 1 -1 = 3