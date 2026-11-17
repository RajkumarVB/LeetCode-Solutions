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
        if(head == null || head.next == null) return; 
        ListNode slow = head, fast = head.next; 
        
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }

        ListNode reversedHead = reverseList(slow.next); 
        ListNode itr1 = head, itr2= reversedHead; 
        while(itr2 != null){
            ListNode itr1Next = itr1.next; 
            ListNode itr2Next = itr2.next; 
            itr1.next = itr2; 
            itr2.next = itr1Next; 
            itr1 = itr1Next; 
            itr2 = itr2Next; 
        }
        itr1.next = null; 

    }
    private ListNode reverseList(ListNode head){
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