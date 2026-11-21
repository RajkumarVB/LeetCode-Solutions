/*
 * 234. Palindrome Linked List  [Easy]
 * https://leetcode.com/problems/palindrome-linked-list/
 * Topics: Linked List, Two Pointers, Stack, Recursion
 *
 * Problem:     Return whether a singly linked list reads the same forwards and backwards.
 * Example:     1->2->2->1 -> true
 * Constraints: <= 1e5 nodes
 *
 * Key idea:    O(1) space: find the middle with slow/fast pointers, reverse the second
 *              half, and compare it with the first half node by node.
 *
 * Approach:    Find middle, reverse second half, compare
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: Copy values to an array + two pointers
 * Submitted:   2023-10-21 (submission 1080475040, AC)
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
    public boolean isPalindrome(ListNode head) {
        ListNode middleNode = findMiddle(head);
        middleNode = reverseLinkedList(middleNode);
        ListNode left = head, right = middleNode; 
        while(right != null){
            if(left.val != right.val) return false ;
            left = left.next; 
            right = right.next; 
        }
        return true; 

    }
    public ListNode reverseLinkedList(ListNode head){
        if(head ==null || head.next ==null) return head;
        ListNode prev = null, curr = head, currNext = head.next;
        while(currNext != null){
            curr.next = prev; 
            prev = curr; 
            curr = currNext; 
            currNext = currNext.next; 
        }
        curr.next = prev; 
        return curr; 
    }
    public ListNode findMiddle(ListNode head){
        if(head ==null || head.next ==null) return head;
        ListNode fast = head, slow = head; 
        while(fast != null && fast.next != null){
            fast = fast.next.next; 
            slow = slow.next; 
        }
        return slow; 
    }
}