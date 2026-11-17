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
        ListNode itr1 = l1, itr2 = l2; 
        ListNode result = new ListNode(-1); 
        ListNode resultItr = result; 
        int carry = 0; 
        while(itr1 != null && itr2 != null){
            int val1 = itr1.val; 
            int val2 = itr2.val; 
            int val = 0; 
            if(val1 + val2 + carry >= 10){
                val = (val1 + val2 + carry) % 10; 
                carry = 1; 
            }else{
                val = val1+ val2 + carry; 
                carry = 0; 
            }
            ListNode temp = new ListNode(val); 
            resultItr.next = temp; 
            resultItr = temp; 
            itr1= itr1.next; 
            itr2 = itr2.next; 
        }
        while(itr1 != null){
            int val = 0; 
            if(itr1.val + carry  >= 10){
                carry = 1; 
                val = (itr1.val + carry) % 10; 
            }else{
                itr1.val = itr1.val + carry; 
                resultItr.next = itr1; 
                carry = 0;
                break; 
            }
            ListNode temp = new ListNode(val); 
            resultItr.next = temp; 
            resultItr = temp; 
            itr1= itr1.next; 
        }
        while(itr2 != null){
            int val = 0; 
            if(itr2.val + carry  >= 10){
                carry = 1; 
                val = (itr2.val + carry) % 10; 
            }else{
                itr2.val = itr2.val + carry; 
                resultItr.next = itr2; 
                carry = 0;
                break; 
            }
            ListNode temp = new ListNode(val); 
            resultItr.next = temp; 
            resultItr = temp; 
            itr2= itr2.next; 
        }
        if(carry == 1){
            ListNode temp = new ListNode(1);
            resultItr.next = temp; 
            resultItr = temp; 
        }
        return result.next; 
    }
}