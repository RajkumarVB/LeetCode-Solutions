class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        return solve(nums,0,n,false);
    }
    public int solve(int[] nums,int i, int n, boolean firstTaken){
        if(i > n-1) return 0; 
        if(i == n-1 && !firstTaken) return nums[n-1]; 
        if(i == n-1) return 0; 
        int path1 =0; 
        int path2 =0; 
        if(i == 0){
            path1 = nums[i] + solve(nums,i+2,n,true); 
        } else {
            path1 = nums[i] + solve(nums,i+2,n,firstTaken); 
        }
        path2 = solve(nums,i+1,n,firstTaken);
        return Math.max(path1, path2); 
    }
}