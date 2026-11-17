class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return findWays(n-1,0, nums, target); 
    }
    public int findWays(int i, int sum, int[] nums, int target){
        if(i < 0){
            if(target == sum) return 1; 
            return 0; 
        }
        int pos = findWays(i-1,sum+nums[i], nums, target);
        int neg = findWays(i-1,sum-nums[i], nums, target);
        return pos + neg; 
    }
}