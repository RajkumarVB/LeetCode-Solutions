class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length; 
        int[] result = new int[n]; 
        LinkedList<Integer> stack = new LinkedList<>(); 
        for(int i= 2*n -1; i>=0; i--){
            while(!stack.isEmpty() && stack.getLast() <= nums[i%n]){
                stack.removeLast(); 
            }

            if(i < n){
                if(!stack.isEmpty()){
                    result[i] = stack.getLast();
                 } else{
                    result[i] = -1;
                }
            }
            
            stack.addLast(nums[i%n]); 
        }
        return result; 
    }
}