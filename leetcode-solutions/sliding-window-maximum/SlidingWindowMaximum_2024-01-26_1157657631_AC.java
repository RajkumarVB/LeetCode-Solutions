class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length; 
        LinkedList<Integer> result = new LinkedList<>(); 
        Deque<Integer> deque = new LinkedList<>(); 
        for(int i=0; i<n; i++){
            //Out of bound case 
            while(!deque.isEmpty() && deque.getFirst() <= i-k) 
                deque.removeFirst(); 
            
            // Remove the first element, if the first element in the deque is smaller. 
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
                deque.removeLast(); 
            }
            
            deque.addLast(i); 

            if(i >= k-1)
                result.add(nums[deque.getFirst()]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray(); 
    }
}