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
    public void reorderList(ListNode head) {
        if(head == null) return; 
        List<ListNode> list = new ArrayList<>();
        
        while(head != null){
            list.add(head);
            head = head.next; 
        }

        int n = list.size();
        int left =0, right = n-1; 
        while(left <= right){
            if(left != right){
                ListNode lNode = list.get(left); 
                ListNode rNode = list.get(right); 
                lNode.next = rNode; 
                rNode.next = (left + 1 < right) ? list.get(left + 1) : null; 
            }else{
                list.get(left).next = null; 
            }
            left ++; right --; 
        }
    }
}