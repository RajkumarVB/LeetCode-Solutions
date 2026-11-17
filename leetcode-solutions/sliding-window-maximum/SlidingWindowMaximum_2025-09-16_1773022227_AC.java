class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length; 
        int left =0, right = 0; 
        LinkedList<Integer> deque = new LinkedList<>(); 
        List<Integer> result = new LinkedList<>(); 
        while(right < n){
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[right]){
                deque.removeLast(); 
            }
            if(!deque.isEmpty() && deque.getFirst() < left){
                deque.removeFirst(); 
            }
            deque.addLast(right); 
            if(right >= k-1){
                result.add(nums[deque.getFirst()]); 
                left ++; 
            }
            right ++; 
        }
        return result.stream().mapToInt(ele -> ele.intValue()).toArray();

    }
}