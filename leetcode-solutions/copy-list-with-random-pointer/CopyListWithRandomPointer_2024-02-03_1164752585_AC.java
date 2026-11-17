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
        HashMap<Node, Node> map = new HashMap<>(); 
        Node itr = head; 
        while(itr != null){
            map.put(itr, new Node(itr.val)); 
            itr = itr.next;
        }
        itr = head; 
        while(itr != null){
            map.get(itr).next = map.get(itr.next); 
            map.get(itr).random = map.get(itr.random); 
            itr = itr.next; 
        }
        return map.get(head); 
    }
}