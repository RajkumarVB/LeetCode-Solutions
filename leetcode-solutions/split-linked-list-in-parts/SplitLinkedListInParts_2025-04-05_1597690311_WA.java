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
        int noOfCuts = k - 1;
        int nodesPerCut; 

        if(count < k){
            nodesPerCut = 1; 
        }else{
            nodesPerCut = count / k ;
        }
        return cutLinkedList(head,noOfCuts,nodesPerCut,k); 
    }

    private ListNode[] cutLinkedList(ListNode head, int noOfCuts, int nodesPerCut, int k){
        List<ListNode> ans = new LinkedList<>(); 
        ListNode tempHead = head;
        for(int i=0; i<noOfCuts; i++){
            ans.add(tempHead); 
            ListNode nodeIter = tempHead; 
            if(nodesPerCut != 1){
                if(i ==0 ){
                    for(int j=0; j<nodesPerCut; j++){
                        nodeIter = nodeIter.next; 
                    }
                }else{
                    for(int j=0; j<nodesPerCut -1; j++){
                        nodeIter = nodeIter.next; 
                    }
                }
            }
            
            if(nodeIter != null) tempHead = nodeIter != null ? nodeIter.next : null; 
            if(nodeIter != null) nodeIter.next = null; 
        }
        if(tempHead != null) ans.add(tempHead); 
        int nullsCountToAdd = k - ans.size(); 
        for(int i=0; i<nullsCountToAdd; i++) ans.add(null); 
        return ans.toArray(new ListNode[0]); 
    }
}