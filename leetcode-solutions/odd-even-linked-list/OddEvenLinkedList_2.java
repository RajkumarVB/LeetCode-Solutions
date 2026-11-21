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
 * Approach:    Build a new list in two passes
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: In-place odd/even chains
 * Submitted:   2024-01-06 (submission 1138253989, AC)
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
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;

        ListNode tempHead = head;
        boolean isOdd = true;
        while(tempHead != null){
            if(isOdd){
                tail.next = new ListNode(tempHead.val);;
                tail = tail.next;
            }
            isOdd = !isOdd;
            tempHead = tempHead.next;
        }

        tempHead = head;
        boolean isEven = false;
        while(tempHead != null){
            if(isEven){
                tail.next = new ListNode(tempHead.val);
                tail = tail.next;
            }
            isEven = !isEven;
            tempHead = tempHead.next;
        }
        return newHead.next;
    }
}