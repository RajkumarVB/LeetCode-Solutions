/*
 * 2. Add Two Numbers  [Medium]
 * https://leetcode.com/problems/add-two-numbers/
 * Topics: Linked List, Math, Recursion
 *
 * Problem:     Two linked lists hold the digits of two numbers in reverse order (ones digit
 *              first). Return their sum as a linked list in the same format.
 * Example:     2->4->3 + 5->6->4 -> 7->0->8 (342 + 465 = 807)
 * Constraints: 1..100 nodes per list
 *
 * Key idea:    Walk both lists together with a carry, treating a finished list as 0. Loop
 *              while either list or carry remains; a dummy head simplifies building the
 *              result.
 *
 * Approach:    Single loop with carry and dummy head
 * Complexity:  time O(max(m,n)), space O(1) extra
 * Submitted:   2024-02-03 (submission 1164760680, AC)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { 
        int carry = 0; 
        ListNode result = new ListNode(-1); 
        ListNode itr1 = l1, itr2 = l2, resultItr = result;
        while(itr1 != null || itr2 != null || carry != 0){
            int itr1Val, itr2Val; 
            itr1Val = (itr1 == null) ? 0 : itr1.val; 
            itr2Val = (itr2 == null) ? 0 : itr2.val; 

            int sum = itr1Val + itr2Val + carry ;
            resultItr.next = new ListNode(sum % 10); 

            carry = (sum >= 10) ? 1 : 0; 

            if(itr1 != null) itr1 = itr1.next; 
            if(itr2 != null) itr2 = itr2.next; 
            resultItr = resultItr.next; 
        }
        return result.next; 
    }
}