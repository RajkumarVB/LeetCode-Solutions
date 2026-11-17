class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length; 
        LinkedList<Integer> stack = new LinkedList<>();
        int[] result = new int[n]; 
        for(int i=2*n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[i%n] >= stack.getLast()){
                stack.removeLast(); 
            }
            if(i <= n-1){
                if(!stack.isEmpty()){
                result[i] = stack.getLast();
                }else{
                    result[i] = -1; 
                }
            }
            
            stack.addLast(nums[i%n]);
        }
        return result; 
    }
}