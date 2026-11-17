class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0 , consectiveOnesSoFar = 0 ; 
        for(var element : nums){
            if(element == 1){
                consectiveOnesSoFar++; 
                result = Math.max(consectiveOnesSoFar,result);
            } else{
                consectiveOnesSoFar =0 ; 
            }
        }
        return result ;
    }
}