/*
 * 160. Intersection of Two Linked Lists  [Easy]
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Topics: Hash Table, Linked List, Two Pointers
 *
 * Problem:     Return the node where two singly linked lists merge, or null.
 * Example:     A: 4->1->8->4->5, B: 5->6->1->8->4->5 -> node 8
 * Constraints: lengths <= 3e4
 *
 * Key idea:    HashSet of nodes from list A works in O(n) space. O(1) space: walk pointers
 *              a and b; when one reaches the end, jump to the other list's head. They meet
 *              at the intersection (or both reach null) after at most m + n steps.
 *
 * Approach:    HashSet of nodes from list A
 * Complexity:  time O(m + n), space O(m)
 * Submitted:   2023-12-27 (submission 1129147176, AC)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null; 
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = headA; 
        while(temp != null){
            set.add(temp);
            temp = temp.next; 
        }
        temp = headB; 
        while(temp != null){
            if(set.contains(temp)) return temp; 
            temp = temp.next; 
        }
        return null; 
    }
}