class Solution {
    public int singleNumber(int[] nums) {
        int result = 0 ; 
        for(var element : nums){
            result ^= element; 
        }
        return result ; 
    }
}