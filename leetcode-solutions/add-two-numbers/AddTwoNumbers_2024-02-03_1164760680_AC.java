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
        int carry = 0; 
        ListNode result = new ListNode(-1); 
        ListNode itr1 = l1, itr2 = l2, resultItr = result;
        while(itr1 != null || itr2 != null || carry != 0){
            int itr1Val, itr2Val; 
            itr1Val = (itr1 == null) ? 0 : itr1.val; 
            itr2Val = (itr2 == null) ? 0 : itr2.val; 

            int sum = itr1Val + itr2Val + carry ;
            resultItr.next = new ListNode(sum % 10); 

            carry = (sum >= 10) ? 1 : 0; 

            if(itr1 != null) itr1 = itr1.next; 
            if(itr2 != null) itr2 = itr2.next; 
            resultItr = resultItr.next; 
        }
        return result.next; 
    }
}