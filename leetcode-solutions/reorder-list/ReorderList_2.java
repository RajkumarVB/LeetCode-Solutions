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
 * Approach:    Nodes in an array + two pointers
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: Middle + reverse second half + interleave
 * Submitted:   2025-09-25 (submission 1782468518, AC)
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
        if(head == null) return; 
        List<ListNode> list = new ArrayList<>();
        
        while(head != null){
            list.add(head);
            head = head.next; 
        }

        int n = list.size();
        int left =0, right = n-1; 
        while(left <= right){
            if(left != right){
                ListNode lNode = list.get(left); 
                ListNode rNode = list.get(right); 
                lNode.next = rNode; 
                rNode.next = (left + 1 < right) ? list.get(left + 1) : null; 
            }else{
                list.get(left).next = null; 
            }
            left ++; right --; 
        }
    }
}