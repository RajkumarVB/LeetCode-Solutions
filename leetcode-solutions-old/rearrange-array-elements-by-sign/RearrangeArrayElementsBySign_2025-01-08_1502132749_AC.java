class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length; 
        int ans[] = new int[n];
        int nextPostivePointer =0, nextNegativePointer = 1; 
        for(int element : nums){
            if(element > 0){
                ans[nextPostivePointer] = element; 
                nextPostivePointer +=2; 
            }else{
                ans[nextNegativePointer] = element; 
                nextNegativePointer +=2; 
            }
        }
        return ans; 
    }
}