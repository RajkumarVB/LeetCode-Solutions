/*
 * 876. Middle of the Linked List  [Easy]
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * Topics: Linked List, Two Pointers
 *
 * Problem:     Return the middle node of a linked list (the second middle if there are
 *              two).
 * Example:     1->2->3->4->5 -> node 3
 * Constraints: <= 100 nodes
 *
 * Key idea:    Slow/fast pointers: when fast reaches the end, slow is at the middle.
 *
 * Approach:    Slow and fast pointers
 * Complexity:  time O(n), space O(1)
 * Submitted:   2024-01-06 (submission 1138170402, AC)
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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head; 
        while(fast != null && fast.next != null){
            fast = fast.next.next; 
            slow = slow.next; 
        }
        return slow; 
    }
}