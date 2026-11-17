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
        if(head.next == null && n==1) return null; 

        ListNode left = head, right = head; 
        while(right != null && n!=0){
            right = right.next; 
            n--; 
        }
        if(right == null){
            return removeFistNode(head); 
        }

        while(right != null && right.next != null){
            right = right.next; 
            left = left.next; 
        }

        removeNextNode(left); 
        return head; 
    }
    public void removeNextNode(ListNode node){
        if(node == null || node.next == null) return; 
        //Atleast two nodes are present at this point. 
        node.next = node.next.next; 
    }

    public ListNode removeFistNode(ListNode head){
        if(head == null) return null; 
        return head.next; 
    }
}
