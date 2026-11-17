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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1); 
        ListNode resultItr = dummyNode; 
        ListNode itr1 = list1, itr2 = list2; 
        if(list1 == null) return list2; 
        if(list2 == null) return list1; 
        while(itr1 != null && itr2 != null){
            if(itr1.val <= itr2.val){
                resultItr.next = itr1; 
                itr1 = itr1.next; 
            }else{
                resultItr.next = itr2; 
                itr2 = itr2.next; 
            }
            resultItr = resultItr.next; 
        }
        if(itr1 != null){
            resultItr.next = itr1; 
        }else if (itr2 != null){
            resultItr.next = itr2; 
        }
        return dummyNode.next; 
    }
}