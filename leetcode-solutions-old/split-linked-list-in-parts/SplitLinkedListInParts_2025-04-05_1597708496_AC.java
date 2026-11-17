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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode tempHead = head; 
        int count = 0; 
        while(tempHead != null){
            count ++; 
            tempHead = tempHead.next; 
        }
        int nodes = count / k; 
        int remainder = count %k; 

        List<ListNode> ans = new LinkedList<>(); 
        tempHead = head;
        for(int i=0; i<k; i++){
            ans.add(tempHead); 
            ListNode nodeIter = tempHead; 
            int extra = (remainder > 0) ? 1 : 0; 
            for(int j=0; j<nodes + extra -1; j++){
                if(nodeIter == null) break; 
                nodeIter = nodeIter.next; 
            }
            if(remainder != 0) remainder -=1; 
            tempHead = nodeIter != null ? nodeIter.next : null; 
            if(nodeIter != null) nodeIter.next = null; 
        }
        return ans.toArray(new ListNode[0]); 
    }
}