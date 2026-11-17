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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head; 
        // At this point, we have atleast two nodes 
        ListNode middle = findMiddle(head);
        ListNode leftHead = head; 
        ListNode rightHead = middle.next;
        middle.next = null;  

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return mergeSortedList(leftHead,rightHead); 
    }

    public ListNode findMiddle(ListNode head){
        if(head == null || head.next == null) return head; 
        ListNode slow = head; 
        ListNode fast = head.next; 
        while(fast != null && fast.next != null){
            fast = fast.next.next; 
            slow = slow.next; 
        }
        return slow; 
    }

    public ListNode mergeSortedList(ListNode head1, ListNode head2){
        ListNode head = new ListNode(-1); 
        ListNode tail = head; 
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                tail.next = head1; 
                head1 = head1.next; 
            } else {
                tail.next = head2; 
                head2 = head2.next; 
            }
            tail = tail.next; 
        }
        tail.next = (head1 != null) ? head1 : head2 ; 
        return head.next; 
    }
}