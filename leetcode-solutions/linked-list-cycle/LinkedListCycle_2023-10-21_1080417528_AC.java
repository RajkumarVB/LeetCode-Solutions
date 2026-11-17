/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //Handling 0/1 node case 
        if(head == null || head.next == null) return false; 
        ListNode slow = head, fast = head.next; 
        while(fast != null && fast.next != null){
            if(slow == fast) return true; 
            fast = fast.next.next; 
            slow = slow.next; 
        }
        return false; 
    }
}