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
        ListNode temp = head; 
        HashMap<Integer,ListNode> map = new HashMap<>(); 
        int count =1 ; 
        while(temp != null){
            map.put(count,temp);
            temp = temp.next; 
            count ++; 
        }
        count --; 
        // System.out.println("Count = " + count); 

        ListNode prev = null; 
        for(int i=1; i<= (count + 1)/2 ; i++){
            ListNode temp1 = map.getOrDefault(i,null); 
            ListNode temp2 = map.getOrDefault(count - i + 1, null); 
            // System.out.println("Temp 1 = " + temp1.val + "Temp 2 = " + temp2.val); 
            if(temp1 != temp2) temp1.next = temp2; 
            
            if(i != 1) prev.next = temp1; 
            prev = temp2; 
        }
        if(prev != null){
            prev.next = null; 
        }
    }
}