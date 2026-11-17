class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length; 
        Deque<Integer> stack = new LinkedList<>(); 
        int[] ans = new int[n]; 
        for(int i=2*n -1; i>=0; i--){
            if(i < n){
                while(!stack.isEmpty() && stack.getLast() <= nums[i]){
                    stack.removeLast(); 
                }
                ans[i] = stack.isEmpty() ? -1 : stack.getLast(); 
            }
            stack.addLast(nums[i%n]); 
        }
        return ans; 
    }
}