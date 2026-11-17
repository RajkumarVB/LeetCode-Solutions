class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length ;
        for(int i=0 ; i<nums.length; i++){
            result = result ^ i ^ nums[i];
        }
        return result ;
    }
}
//  0 1 2 3
// [3,0,1]
// [0,1,2,3]