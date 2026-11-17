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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val1 = getValue(l1);
        int val2 = getValue(l2);
        int result = val1 + val2 ;

        ListNode ansList = createList(result); 
        return ansList; 
    }

    public static int getValue(ListNode head){
        int result = 0, exponent = 1; 
        ListNode temp = head; 

        while(temp != null){
            result += (temp.val * exponent);
            exponent *= 10; 
            temp = temp.next; 
        }
        return result; 

    } 

    public static ListNode createList(int result){
        ListNode head = new ListNode(result % 10, null); 
        result /= 10; 

        ListNode temp = head; 
        while(result != 0){
            temp.next = new ListNode(result%10, null);
            temp = temp.next; 
            result /= 10; 
        }
        return head; 
    }
}