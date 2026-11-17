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
    public ListNode oddEvenList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;

        ListNode tempHead = head;
        boolean isOdd = true;
        while(tempHead != null){
            if(isOdd){
                tail.next = new ListNode(tempHead.val);;
                tail = tail.next;
            }
            isOdd = !isOdd;
            tempHead = tempHead.next;
        }

        tempHead = head;
        boolean isEven = false;
        while(tempHead != null){
            if(isEven){
                tail.next = new ListNode(tempHead.val);
                tail = tail.next;
            }
            isEven = !isEven;
            tempHead = tempHead.next;
        }
        return newHead.next;
    }
}