/*
 * 138. Copy List with Random Pointer  [Medium]
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * Topics: Hash Table, Linked List
 *
 * Problem:     Deep-copy a linked list whose nodes have both next and random pointers.
 * Example:     [[7,null],[13,0],[11,4],[10,2],[1,0]] -> identical new list
 * Constraints: n <= 1000
 *
 * Key idea:    Pass 1: create a clone for every node in a map old -> new. Pass 2: set
 *              clone.next = map[old.next] and clone.random = map[old.random]. (O(1)-space
 *              trick: interleave clones in the original list.)
 *
 * Approach:    Two passes with old->new HashMap
 * Complexity:  time O(n), space O(n)
 * Submitted:   2025-09-29 (submission 1786532055, AC)
 */

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null; 
        HashMap<Node, Node> map = new HashMap<>(); // old Node -> New Node map
        Node itr = head; 
        while(itr != null){
            Node newNode = new Node(itr.val); 
            map.put(itr, newNode); 
            itr = itr.next; 
        }
        itr = head; 
        while(itr != null){
            
            Node newNode = map.get(itr); 
            newNode.next = (itr.next != null) ? map.get(itr.next) : null; 
            newNode.random = (itr.random != null) ? map.get(itr.random) : null; 
            itr = itr.next; 
        }
        return map.get(head); 
    }
}