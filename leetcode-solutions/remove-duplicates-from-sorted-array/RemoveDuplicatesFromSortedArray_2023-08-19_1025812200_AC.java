class Solution {
    public int removeDuplicates(int[] nums) {
        int uniqueElementsPtr = 0 , n= nums.length;
        for(int j=1; j<n ; j++){
            if(nums[j] != nums[j-1]){
                nums[++uniqueElementsPtr] = nums[j];
            }
        }
        return uniqueElementsPtr +1; 
    }
}