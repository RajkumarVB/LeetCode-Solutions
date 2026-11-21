/*
 * 21. Merge Two Sorted Lists  [Easy]
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Topics: Linked List, Recursion
 *
 * Problem:     Merge two sorted linked lists by splicing their nodes.
 * Example:     1->2->4, 1->3->4 -> 1->1->2->3->4->4
 * Constraints: <= 50 nodes each
 *
 * Key idea:    Dummy head + tail pointer; attach the smaller head each step, then append
 *              whatever remains.
 *
 * Approach:    Iterative with dummy head
 * Complexity:  time O(m + n), space O(1)
 * Submitted:   2025-09-24 (submission 1781503044, AC)
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1); 
        ListNode resultItr = dummyNode; 
        ListNode itr1 = list1, itr2 = list2; 
        if(list1 == null) return list2; 
        if(list2 == null) return list1; 
        while(itr1 != null && itr2 != null){
            if(itr1.val <= itr2.val){
                resultItr.next = itr1; 
                itr1 = itr1.next; 
            }else{
                resultItr.next = itr2; 
                itr2 = itr2.next; 
            }
            resultItr = resultItr.next; 
        }
        if(itr1 != null){
            resultItr.next = itr1; 
        }else if (itr2 != null){
            resultItr.next = itr2; 
        }
        return dummyNode.next; 
    }
}