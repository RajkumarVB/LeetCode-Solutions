// I'll keep the MRU near the tail

class LRUCache {
    private Map<Integer,Node> locationMap; 
    // Key -> Node
    
    private DoublyLinkedList dll; 
   
    private int capacity; 

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        this.dll = new DoublyLinkedList(); 
        this.locationMap = new HashMap<>(); 
    }
    
    public int get(int key) {
        if(locationMap.containsKey(key)){
            Node node = locationMap.get(key); 
            dll.deleteGivenNode(node); 
            dll.addLast(node); 
            return node.value; 
        }
        return -1; 
    }
    
    public void put(int key, int value) {
        if(locationMap.containsKey(key)){
            Node node = locationMap.get(key); 
            node.value = value; 
            dll.deleteGivenNode(node); 
            dll.addLast(node); 
        }else{
            if(dll.getSize() == capacity){
                //evict LRU
                Node LRU = dll.getFirstNode(); 
                dll.deleteGivenNode(LRU);
                locationMap.remove(LRU.key); 
            }
            Node newNode = new Node(key, value); 
            dll.addLast(newNode);
            locationMap.put(key, newNode); 
        }
    }

    class Node{
        Node prev; 
        Node next; 
        int key; 
        int value; 
        
        public Node() {
            this.key = -1; 
            this.value = -1; 
            this.prev = null;
            this.next = null; 
        }

        public Node(int key, int value){
            this.key = key; 
            this.value = value; 
            this.prev = null;
            this.next = null; 
        }
    }

    class DoublyLinkedList{
        private Node head; 
        private Node tail; 
        private int size; 
        public DoublyLinkedList(){
            head = new Node(); 
            tail = new Node(); 
            head.next = tail; 
            tail.prev = head; 
            size =0; 
        }

        private void deleteGivenNode(Node node){
            node.prev.next = node.next; 
            node.next.prev = node.prev; 
            node.next = null; 
            node.prev = null; 
            size -=1; 
        }   

        private void addLast(Node node){
            tail.prev.next = node; 
            node.prev = tail.prev; 
            node.next = tail; 
            tail.prev = node; 
            size += 1; 
        }

        private int getSize(){
            return this.size; 
        }

        private Node getFirstNode(){
            if(size > 0){
                return head.next; 
            }
            return null ; // ideally no node exception 
        }
    }
}


