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
    public ListNode reverseList(ListNode head) {
        // Handling 0/1 node
        if(head ==null || head.next == null) return head; 
        // Sure that LinkedList contains atleast 2 nodes
        ListNode curr =head, currNext =head.next, prev =null; 
        while(currNext != null){
            curr.next = prev; 
            prev = curr; 
            curr = currNext; 
            currNext = currNext.next; 
        }
        curr.next = prev; 
        return curr; 
    }
}