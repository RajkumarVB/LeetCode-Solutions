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
        Node temp = head; 
        HashMap<Node,Node> oldNodeNewNodeMap = new HashMap<>(); 

        while(temp != null){
            Node newNode = new Node(temp.val); 
            oldNodeNewNodeMap.put(temp,newNode); 
            temp = temp.next;
        }

        temp = head; 
        
        while(temp != null){
           Node newNode = oldNodeNewNodeMap.get(temp);
           newNode.next = oldNodeNewNodeMap.get(temp.next);
           newNode.random = oldNodeNewNodeMap.get(temp.random);

           temp = temp.next; 
           //map.get(null) => null
        }
        return oldNodeNewNodeMap.get(head); 
    }
}