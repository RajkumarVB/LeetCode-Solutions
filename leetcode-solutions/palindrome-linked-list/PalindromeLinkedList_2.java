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
 * Approach:    Copy values to an array + two pointers
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: Find middle, reverse second half, compare
 * Submitted:   2023-10-21 (submission 1080470986, AC)
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
        ListNode temp = head; 
        ArrayList<Integer> values = new ArrayList<Integer>();
        while(temp != null){
            values.add(temp.val);
            temp = temp.next; 
        }
        int n = values.size();
        int left = 0 , right = n-1;
        while(left < right){
            if(values.get(left) != values.get(right)) return false;
            left ++;
            right --;
        }
        return true; 
    }
}