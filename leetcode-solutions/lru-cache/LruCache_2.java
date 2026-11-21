/*
 * 146. LRU Cache  [Medium]
 * https://leetcode.com/problems/lru-cache/
 * Topics: Hash Table, Linked List, Design, Doubly-Linked List
 *
 * Problem:     Design a Least-Recently-Used cache with O(1) get and put that evicts the
 *              least recently used key when full.
 * Example:     cap 2: put(1,1), put(2,2), get(1)=1, put(3,3) evicts 2, get(2)=-1
 * Constraints: <= 2e5 calls
 *
 * Key idea:    HashMap key -> node plus a doubly linked list ordered by recency, with dummy
 *              head and tail. On access, move the node to the front; on overflow, remove
 *              the node before the tail.
 *
 * Approach:    HashMap + java.util.LinkedList (remove is O(n))
 * Complexity:  time O(n) get/put, space O(capacity)
 * Also see:    _1: HashMap + hand-written doubly linked list
 * Submitted:   2026-01-22 (submission 1892518483, AC)
 */

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