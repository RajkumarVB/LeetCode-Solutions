class LRUCache {
    private int capacity; 

    // key -> LL node
    private HashMap<Integer, Node> cache; 

    // recency list
    private LinkedList<Node> list; 

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        this.cache = new HashMap<>(capacity);
        this.list = new LinkedList<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1; 
        // cache hit, so update the recency
        Node node = cache.get(key);
        list.remove(node);
        list.addFirst(node);
        return node.value; 
    }
    
    public void put(int key, int value) {

        if(cache.containsKey(key)){
            Node node = cache.get(key);
            list.remove(node);
            list.addFirst(node);
            node.value = value; 
            return; 
        }


        Node newNode = new Node(key, value);

        if(list.size() >= capacity){
            // evict least recently used 
            Node evicted = list.removeLast();
            cache.remove(evicted.key);
           
        }

        list.addFirst(newNode);
        cache.put(key, newNode);
    }
    
    class Node{
        int key; 
        int value; 
        public Node(int key, int value){
            this.key = key; 
            this.value = value; 
        }
    }
}

// for get method, i need a hashmap key -> value 
//  to maintain the ordering/recency, i can maintain a linkedlist
// i'll maintain the recent ones at the beginning of the LL





/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */