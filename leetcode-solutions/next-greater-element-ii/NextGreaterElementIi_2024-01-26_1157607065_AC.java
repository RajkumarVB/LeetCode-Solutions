class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length; 
        List<Integer> result = new LinkedList<>(); 
        LinkedList<Integer> stack = new LinkedList<>(); 
        for(int i= 2*n -1; i>=0; i--){
            while(!stack.isEmpty() && stack.getLast() <= nums[i%n]){
                stack.removeLast(); 
            }

            if(i < n){
                if(!stack.isEmpty()){
                    result.addFirst(stack.getLast()); // At the end, we need to reverse, so instead of that adding First. 
                } else{
                    result.addFirst(-1); 
                }
            }
            
            stack.addLast(nums[i%n]); 
        }
        return result.stream().mapToInt(Integer::intValue).toArray(); 
    }
}