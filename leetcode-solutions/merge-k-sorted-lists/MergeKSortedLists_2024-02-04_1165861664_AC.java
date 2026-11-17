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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1,n2) -> n1.val - n2.val);
        for(ListNode node : lists){
            if(node != null) pq.offer(node); 
        }
        ListNode resultHead = new ListNode(-1); 
        ListNode resultItr = resultHead; 
        while(!pq.isEmpty()){
            ListNode node = pq.poll(); 
            resultItr.next = node; 
            resultItr = resultItr.next; 
            if(node.next != null) pq.offer(node.next); 
        }
        return resultHead.next; 
    }
}