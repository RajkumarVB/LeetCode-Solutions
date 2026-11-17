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