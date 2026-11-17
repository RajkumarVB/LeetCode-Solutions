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
                prevNode.next = kthNode; 
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