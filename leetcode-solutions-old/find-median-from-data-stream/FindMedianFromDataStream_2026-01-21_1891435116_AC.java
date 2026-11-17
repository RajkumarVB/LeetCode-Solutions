class MedianFinder {
    private PriorityQueue<Integer> small; 
    private PriorityQueue<Integer> large; 
    public MedianFinder() {
        small = new PriorityQueue<>((a,b) -> b-a); // max heap
        large = new PriorityQueue<>((a,b) -> a-b); // min heap


    }
    
    public void addNum(int num) {
        small.offer(num);

        // if we need to put some elements to max heap do that
        if(small.size() - large.size() > 1 || (!large.isEmpty() && small.peek() > large.peek())){
            large.offer(small.poll());
        }

        // now large might have more elements than small
        if(large.size() - small.size() > 1){
            small.offer(large.poll());
        }

    }
    
    public double findMedian() {
        if(small.size() == large.size()){
            return ((small.peek() + large.peek()) / 2.0);
        }else if(small.size() > large.size()){
            return (double) small.peek();
        }else{
            return (double) large.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */