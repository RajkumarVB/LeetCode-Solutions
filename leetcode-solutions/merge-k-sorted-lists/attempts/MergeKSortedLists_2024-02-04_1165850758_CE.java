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
    public ListNode mergeKLists(ListNode[] lists) {
        
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1 == null) return list2; 
        if(list2 == null) return list1; 
        ListNode itr1 = list1, itr2 = list2; 
        ListNode resultHead = new ListNode(-1); 
        ListNode resultItr = resultHead; 
        while(itr1 != null && itr2 != null){
            if(itr1.val < itr2.val){
                resultItr.next = itr1; 
                itr1 = itr1.next; 
            } else{
                resultItr.next = itr2; 
                itr2 = itr2.next; 
            }
            resultItr = resultItr.next; 
        }
        if(itr1 != null) resultItr.next = itr1; 
    }
}