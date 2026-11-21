/*
 * 141. Linked List Cycle  [Easy]
 * https://leetcode.com/problems/linked-list-cycle/
 * Topics: Hash Table, Linked List, Two Pointers, Floyd's Cycle Finding Algorithm
 *
 * Problem:     Determine whether a linked list contains a cycle.
 * Example:     3->2->0->-4 with tail pointing to node 2 -> true
 * Constraints: <= 1e4 nodes
 *
 * Key idea:    Floyd: slow moves 1, fast moves 2; if there's a cycle they meet, otherwise
 *              fast reaches null. A HashSet of visited nodes also works with O(n) space.
 *
 * Approach:    HashSet of visited nodes
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: Floyd slow/fast pointers
 * Submitted:   2023-12-27 (submission 1129476280, AC)
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        HashSet<ListNode> set = new HashSet<>(); 
        ListNode temp = head; 

        while(temp != null){
            if(set.contains(temp)) return true; 
            set.add(temp); 
            temp = temp.next; 
        }
        return false ;
    }
}