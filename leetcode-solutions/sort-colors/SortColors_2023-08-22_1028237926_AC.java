class Solution {
    public void sortColors(int[] nums) {
        int zeroes = 0, ones = 0 , twos = 0 ;
        for(int element : nums){
            if(element ==0) zeroes ++;
            else if(element ==1) ones ++;
            else twos ++; 
        }
        int i = 0; 
        for(int j = 0; j<zeroes; j++){
            nums[i] = 0 ;
            i++;
        }
        for(int j = 0; j<ones; j++){
            nums[i] = 1 ;
            i++;
        }
        for(int j = 0; j<twos; j++){
            nums[i] = 2 ;
            i++;
        }
    }
}