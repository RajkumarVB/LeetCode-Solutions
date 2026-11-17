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
        ListNode slow = head, fast = head.next; 
        while(fast != null && fast.next != null){
            fast = fast.next.next; 
            slow = slow.next; 
        }
        slow.next = reverseList(slow.next); 
        ListNode first = head, second =  slow.next; 
        slow.next = null; 
        while(second != null){
            ListNode temp3 = first.next, temp4 = second.next; 
            first.next = second; 
            second.next = temp3; 
            first = temp3; 
            second = temp4; 
        }
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