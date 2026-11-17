class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, j, i; 
        boolean isZeroesPresent = false; 
        for(j=0; j<n; j++){
            if(nums[j] ==0){
                isZeroesPresent = true; 
                break; 
            }
        }
        if(!isZeroesPresent) return; 
        for(i = j+1; i<n ; i++){
            if(nums[i] !=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp; 

                j++; 
            }
        }
    }
}