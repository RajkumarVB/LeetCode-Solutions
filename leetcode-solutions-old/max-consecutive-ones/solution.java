class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result =0 , counter=0 ;
        for(int i : nums){
            if(i == 1){
                counter += 1; 
                result = Math.max(result, counter); 
            } else {
                counter =0 ; 
            }
        }
        return result; 
    }
}