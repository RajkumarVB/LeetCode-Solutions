/*
 * 25. Reverse Nodes in k-Group  [Hard]
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Topics: Linked List, Recursion
 *
 * Problem:     Reverse the list's nodes in groups of k; a final group with fewer than k
 *              nodes stays as is.
 * Example:     1->2->3->4->5, k=2 -> 2->1->4->3->5
 * Constraints: n <= 5000
 *
 * Key idea:    Loop: find the kth node from the current group start (stop if missing).
 *              Detach the group, reverse it, and reconnect the previous group's tail to the
 *              new head and the old head (now the tail) to the next group.
 *
 * Approach:    Find kth, detach, reverse, reconnect
 * Complexity:  time O(n), space O(1)
 * Submitted:   2024-02-04 (submission 1165984088, AC)
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, kthNode, prevNode =null, nextNode = null; 
        while(temp != null){
            kthNode = getKthNode(temp,k); 
            if(kthNode == null){
                if(prevNode != null)prevNode.next = temp; 
                break; 
            }
            nextNode = kthNode.next; 
            kthNode.next = null; 
            reverseList(temp); 
            if(temp == head){
                head = kthNode; 
            } else{
                if(prevNode != null) prevNode.next = kthNode; 
            }
            prevNode = temp; 
            temp = nextNode; 
        }
        return head; 
    }
    public ListNode getKthNode(ListNode head, int k){
        k --; 
        while(head != null && k>0){
            head = head.next; 
            k --; 
        }
        return head; 
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head; 
        ListNode prev = null, curr = head, next = head.next; 
        while(next != null){
            curr.next = prev; 
            prev = curr; 
            curr = next; 
            next = next.next; 
        }
        curr.next = prev; 
        return curr; 
    }
}