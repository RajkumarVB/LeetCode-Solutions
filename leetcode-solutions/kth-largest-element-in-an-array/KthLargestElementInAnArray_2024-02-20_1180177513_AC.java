class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((ele1, ele2) -> ele2 - ele1); 
        for(int num : nums){
            pq.offer(num);
        }
        for(int i=0; i<k-1; i++) pq.poll(); 
        return pq.poll(); 
    }
}