class KthLargest {
    private PriorityQueue<Integer> pq; 
    private int k; 
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>(); 
        this.k = k; 
        for(int data : nums) add(data); 
    }
    
    public int add(int val) {
        pq.offer(val); 
        if(pq.size() > k ){
            pq.poll(); 
        }
        return pq.peek(); 
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */