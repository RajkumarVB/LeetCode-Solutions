/*
 * 725. Split Linked List in Parts  [Medium]
 * https://leetcode.com/problems/split-linked-list-in-parts/
 * Topics: Linked List
 *
 * Problem:     Split a linked list into k consecutive parts whose sizes differ by at most
 *              1, with larger parts first (some may be null).
 * Example:     [1..10], k=3 -> [1-4],[5-7],[8-10]
 * Constraints: <= 1000 nodes, k <= 50
 *
 * Key idea:    Count the length L. Each part gets L/k nodes, and the first L%k parts get
 *              one extra. Walk and cut accordingly.
 *
 * Approach:    Count, then cut sizes L/k (+1 for the first L%k)
 * Complexity:  time O(L + k), space O(k)
 * Submitted:   2025-04-05 (submission 1597708496, AC)
 */

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