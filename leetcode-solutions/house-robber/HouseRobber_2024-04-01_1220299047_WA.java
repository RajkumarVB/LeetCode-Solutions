class Solution {
    public int rob(int[] nums) {
        int path1 = 0, path2 = 0;
        int n = nums.length; 
        for(int i=0; i<n; i++){
            if(i % 2 ==0){
                path1 += nums[i];
            } else{
                path2 += nums[i]; 
            }
        }
        return Math.max(path1, path2); 
    }
}