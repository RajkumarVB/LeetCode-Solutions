class LRUCache {
    int capacity; 
    DLL dll; 
    HashMap<Integer,DLLNode> map; 

    class DLLNode{
        int key;
        int value; 
        DLLNode next; 
        DLLNode prev; 
        public DLLNode(int key, int value){
            this.key = key; 
            this.value = value; 
        }
    }

    class DLL{
        DLLNode head; 
        DLLNode tail; 
        int size; 
        public DLL(){
            head = new DLLNode(-1,-1);
            tail = new DLLNode(-1,-1);
            head.next = tail; 
            tail.prev = head; 
            size = 0; 
        }

        public DLLNode removeNode(DLLNode node){
            node.prev.next = node.next; 
            node.next.prev = node.prev; 
            node.next = node.prev = null; 
            size --; 
            return node; 
        }
        public DLLNode removeLastNode(){
            if(size > 0 ){
                DLLNode removedNode = removeNode(tail.prev);
                return removedNode; 
            }
            return null; 
        }
        public void addFirst(DLLNode node){
            node.next = head.next; 
            node.prev = head; 
            head.next.prev = node; 
            head.next = node; 
            size ++; 
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        this.dll = new DLL(); 
        this.map = new HashMap<>(); 
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1; 
        }
        DLLNode node = map.get(key); 
        dll.removeNode(node);
        dll.addFirst(node); 
        return node.value; 
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLLNode node = map.get(key); 
            dll.removeNode(node); 
            dll.addFirst(node); 
            node.value = value; 
            return; 
        }
        if(dll.size == capacity){
            DLLNode removedNode = dll.removeLastNode(); 
            map.remove(removedNode.key); 
        }
        DLLNode newNode = new DLLNode(key,value);
        dll.addFirst(newNode); 
        map.put(key,newNode); 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */