class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length; 
        LinkedList<Integer> stack = new LinkedList<>();
        int[] result = new int[n]; 
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[i] >= stack.getLast()){
                stack.removeLast(); 
            }
            stack.addLast(nums[i]);
        }
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[i] >= stack.getLast()){
                stack.removeLast(); 
            }
            if(!stack.isEmpty()){
                result[i] = stack.getLast();
            }else{
                result[i] = -1; 
            }
            stack.addLast(nums[i]);
        }
        return result; 
    }
}