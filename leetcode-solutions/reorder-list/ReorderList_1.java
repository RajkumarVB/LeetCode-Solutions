/*
 * 143. Reorder List  [Medium]
 * https://leetcode.com/problems/reorder-list/
 * Topics: Linked List, Two Pointers, Stack, Recursion
 *
 * Problem:     Reorder L0 -> L1 -> ... -> Ln into L0 -> Ln -> L1 -> Ln-1 -> ... in place.
 * Example:     1->2->3->4->5 -> 1->5->2->4->3
 * Constraints: <= 5e4 nodes
 *
 * Key idea:    Three classic steps: find the middle (slow/fast), reverse the second half,
 *              then merge the two halves alternately.
 *
 * Approach:    Middle + reverse second half + interleave
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: Nodes in an array + two pointers
 * Submitted:   2025-09-25 (submission 1782494823, AC)
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return; 
        ListNode slow = head, fast = head.next; 
        
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }

        ListNode reversedHead = reverseList(slow.next); 
        slow.next = null;
        ListNode itr1 = head, itr2= reversedHead; 
        while(itr2 != null){
            ListNode itr1Next = itr1.next; 
            ListNode itr2Next = itr2.next; 
            itr1.next = itr2; 
            itr2.next = itr1Next; 
            itr1 = itr1Next; 
            itr2 = itr2Next; 
        }

    }
    private ListNode reverseList(ListNode head){
        ListNode prev = null, curr = head, next = head.next; 
        while(next != null){
            curr.next = prev; 
            prev = curr; 
            curr = next; 
            next = next.next; 
        }
        curr.next = prev; 
        return curr; 
    }
}