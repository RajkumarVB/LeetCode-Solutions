/*
 * 328. Odd Even Linked List  [Medium]
 * https://leetcode.com/problems/odd-even-linked-list/
 * Topics: Linked List
 *
 * Problem:     Reorder a linked list so all odd-position nodes come first, then even-
 *              position nodes, keeping relative order. O(1) extra space.
 * Example:     1->2->3->4->5 -> 1->3->5->2->4
 * Constraints: <= 1e4 nodes
 *
 * Key idea:    Keep two chains (odd and even) and remember evenHead. Advance odd.next =
 *              even.next and even.next = odd.next alternately, then attach evenHead to the
 *              end of the odd chain.
 *
 * Approach:    In-place odd/even chains
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: Build a new list in two passes
 * Submitted:   2024-01-06 (submission 1138271812, AC)
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head; 
        ListNode odd = head; 
        ListNode even = head.next; 
        ListNode evenHead = head.next; 

        while(even != null && even.next != null){
            odd.next = odd.next.next; 
            even.next = even.next.next; 

            odd = odd.next; 
            even = even.next; 
        }

        odd.next = evenHead; 
        return head; 
    }
}