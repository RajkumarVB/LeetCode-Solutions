/*
 * 237. Delete Node in a Linked List  [Medium]
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * Topics: Linked List
 *
 * Problem:     Delete a given (non-tail) node from a singly linked list without access to
 *              the head.
 * Example:     list 4->5->1->9, node 5 -> 4->1->9
 * Constraints: 2..1000 nodes
 *
 * Key idea:    You can't reach the previous node, so copy the next node's value into this
 *              node and unlink the next node: node.val = node.next.val; node.next =
 *              node.next.next. (Your version shifts every later value; the one-step version
 *              is O(1).)
 *
 * Approach:    Shift values forward and drop the tail
 * Complexity:  time O(n), space O(1)
 * Submitted:   2023-10-21 (submission 1080404155, AC)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node; 
        while(curr.next.next != null){
            curr.val = curr.next.val; 
            curr = curr.next; 
        }
        curr.val=curr.next.val; 
        curr.next =null; 
    }
}