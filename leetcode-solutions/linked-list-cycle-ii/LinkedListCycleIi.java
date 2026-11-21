/*
 * 142. Linked List Cycle II  [Medium]
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * Topics: Hash Table, Linked List, Two Pointers, Floyd's Cycle Finding Algorithm
 *
 * Problem:     Return the node where a linked list's cycle begins, or null if there is no
 *              cycle.
 * Example:     3->2->0->-4 with tail pointing to node 2 -> node 2
 * Constraints: <= 1e4 nodes
 *
 * Key idea:    After slow and fast meet, reset slow to head and move both one step at a
 *              time; they meet at the cycle start. (The distance from head to the start
 *              equals the distance from the meeting point to the start, modulo the cycle
 *              length.)
 *
 * Approach:    Floyd meet, then reset to head
 * Complexity:  time O(n), space O(1)
 * Submitted:   2023-10-21 (submission 1080463023, AC)
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null; 
        ListNode fast = head, slow = head; 
        while(fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
            if(slow == fast){
                slow = head; 
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next; 
                }
                return slow; 
            }
        }
        return null;
    }
}