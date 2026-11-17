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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null; 
        ListNode itr1 = head, itr2 = head; 
        for(int i=0; i<n; i++){
            itr2 = itr2.next; 
        }
        while(itr2 != null && itr2.next != null){
            itr1 = itr1.next; 
            itr2 = itr2.next; 
        }
        if(itr2 == null){
            // We need to delete the head node
            return head.next; 
        }else{
            itr1.next = itr1.next.next; 
        }
        return head; 
    }
}