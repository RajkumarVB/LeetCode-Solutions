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
        ListNode temp = head; 
        int count =0; 
        while(temp != null){
            count++; 
            temp = temp.next; 
        }
        temp = head; 
        if(n == count) return temp.next; 
        for(int i=1; i<= count-n-1 ; i++) temp = temp.next; 
        temp.next = temp.next.next; 
        return head; 
    }
}

// 1 2 3 4 5 

// 1
// 5 - 1 -1 = 3