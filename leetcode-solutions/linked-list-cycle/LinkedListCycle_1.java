/*
 * 141. Linked List Cycle  [Easy]
 * https://leetcode.com/problems/linked-list-cycle/
 * Topics: Hash Table, Linked List, Two Pointers, Floyd's Cycle Finding Algorithm
 *
 * Problem:     Determine whether a linked list contains a cycle.
 * Example:     3->2->0->-4 with tail pointing to node 2 -> true
 * Constraints: <= 1e4 nodes
 *
 * Key idea:    Floyd: slow moves 1, fast moves 2; if there's a cycle they meet, otherwise
 *              fast reaches null. A HashSet of visited nodes also works with O(n) space.
 *
 * Approach:    Floyd slow/fast pointers
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: HashSet of visited nodes
 * Submitted:   2025-09-24 (submission 1781509446, AC)
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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false; 
        ListNode slow = head, fast = head; 
        do{
            slow = slow.next; 
            fast = fast.next; 
            if(fast != null){
                fast = fast.next; 
            }
            if(slow == fast) return true; 
        }while(fast != null); 
        return false; 
    }
}