class Solution {
    public int[] singleNumber(int[] nums) {
        long xorAll = 0; 
        for(int ele : nums){
            xorAll ^= ele; 
        }
        long rightMost = (xorAll & (xorAll -1)) ^ xorAll; 
        long bucket1 =0, bucket2 =0; 
        for(int ele : nums){
            if((ele & rightMost) ==0){
                bucket1 ^= ele; 
            } else{
                bucket2 ^= ele; 
            }
        }
        return new int[]{(int)bucket1, (int)bucket2}; 
    }
}