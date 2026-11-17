class Solution {
    public int subsetXORSum(int[] nums) {
        int result =0; 
        int n = nums.length; 
        for(int i=0; i< (1<<n); i++){
            int subsetXor = 0; 
            for(int j=0; j<n; j++){
                if((i & (1 << j)) != 0){
                    subsetXor ^= nums[j]; 
                }
            }
            result += subsetXor; 
        }
        return result; 
    }
}