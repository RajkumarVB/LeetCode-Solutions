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
        ListNode itr1 = head, itr2 = head; 
        
        for(int i=0; i<n; i++){
            itr2 = itr2.next; 
        }
        if(itr2 == null) return itr1.next; 

        while(itr2 != null && itr2.next != null){
            itr1 = itr1.next; 
            itr2 = itr2.next; 
        }
        if(itr1.next == itr2){
            itr1.next = null; 
        }else{
            itr1.next = itr2; 
        }
        return head; 
    }
}