class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length; 
        int left =0, right = 0; 
        LinkedList<Integer> deque = new LinkedList<>(); 
        int[] result = new int[n-k+1];
        while(right < n){
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[right]){
                deque.removeLast(); 
            }
            deque.addLast(right); 
            if(deque.getFirst() < left){
                deque.removeFirst(); 
            }
            
            if(right >= k-1){
                result[left] = nums[deque.getFirst()]; 
                left ++; 
            }
            right ++; 
        }
        return result;
    }
}