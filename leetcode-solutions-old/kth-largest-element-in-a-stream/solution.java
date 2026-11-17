class KthLargest {
    private PriorityQueue<Integer> pq; 
    int k; 

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((i1, i2) -> i1-i2);
        this.k = k; 

        for(int element : nums){
            pq.add(element);

            int size = pq.size();
            
            while(size > k){
                pq.poll();
                size --; 
            }
        } 

    }
    
    public int add(int val) {
        pq.add(val); 
        int size = pq.size();
        while(size > k){
            pq.poll();
            size --; 
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */