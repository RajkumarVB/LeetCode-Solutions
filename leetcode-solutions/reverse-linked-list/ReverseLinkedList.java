/*
 * 206. Reverse Linked List  [Easy]
 * https://leetcode.com/problems/reverse-linked-list/
 * Topics: Linked List, Recursion
 *
 * Problem:     Reverse a singly linked list.
 * Example:     1->2->3->4->5 -> 5->4->3->2->1
 * Constraints: <= 5000 nodes
 *
 * Key idea:    Iterative three-pointer pattern: save next, point curr.next to prev, advance
 *              prev and curr. Recursive: reverse the rest, then head.next.next = head;
 *              head.next = null.
 *
 * Approach:    Iterative prev/curr/next
 * Complexity:  time O(n), space O(1)
 * Submitted:   2023-10-17 (submission 1077196635, AC)
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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null; 
        while(curr != null){
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }
        return prev; 
    }
}