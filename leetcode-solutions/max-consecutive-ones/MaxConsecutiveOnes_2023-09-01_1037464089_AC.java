class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0 ; 
        int consecutiveOnes = 0 ; 
        for(int element : nums){
            if(element == 1){
                consecutiveOnes ++; 
                result = Math.max(result,consecutiveOnes);
            } else{
                consecutiveOnes = 0 ;
            }
        }
        return result ; 
    }
}