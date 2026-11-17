class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length; 
        int badPairsCount = 0; 
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                // Check if (i, j) is a bad pair
                if(isBadPair(nums,i,j)){
                    badPairsCount ++; 
                } 
            }
        }
        return badPairsCount; 
    }
    public boolean isBadPair(int[] nums, int i, int j){
        return (nums[j] - nums[i]) != (j - i); 
    }
}