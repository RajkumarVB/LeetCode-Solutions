class LRUCache {

    private HashMap<Integer,DLLNode> keyNodemap = new HashMap<>();
    private final int CAPACITY;
    private DLL dll;
    class DLLNode{
        int key;
        int value;

        DLLNode prev;
        DLLNode next;

        public DLLNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class DLL{
        private DLLNode head;
        private DLLNode tail;
        public DLL(){
            head = new DLLNode(0,0);
            tail = new DLLNode(0,0);
            head.next = tail;
            head.prev = null;
            tail.prev = head;
            tail.next = null;
        }

        public void addFirst(DLLNode node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(DLLNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
        public DLLNode removeLast(){
            DLLNode node = tail.prev;
            tail.prev = node.prev;
            node.prev.next = tail;
            node.next = null;
            node.prev = null;
            return node;
        }
    }

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        this.dll = new DLL();
    }

    public int get(int key) {
        DLLNode node = keyNodemap.get(key);
        if(node == null) return -1;

        dll.removeNode(node);
        dll.addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(keyNodemap.containsKey(key)){
            DLLNode node =keyNodemap.get(key);
            node.value = value;
            dll.removeNode(node);
            dll.addFirst(node);
            return;
        }
        if(keyNodemap.size() == CAPACITY){
            DLLNode node = dll.removeLast();
            keyNodemap.remove(node.key);
        }
        DLLNode newNode = new DLLNode(key,value);
        keyNodemap.put(key,newNode);
        dll.addFirst(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */