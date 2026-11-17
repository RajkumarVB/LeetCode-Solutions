class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        int n = nums.length; 
        for(int i=0; i<n; i++) sum += nums[i]; 
        if(sum %2 !=0) return false; // If sum is odd you cannot split it to two subsets of equal sum. 

        int sumToLookFor = sum/2 ; 

        boolean[] prev = new boolean[sumToLookFor + 1]; 
        prev[0] = true; 

        if(nums[0] <= sumToLookFor){
            prev[nums[0]] = true; 
        }

        for(int index =1; index <n ; index++){
            boolean[] curr = new boolean[sumToLookFor+1];
            curr[0] = true; 
            for(int target = 1; target <= sumToLookFor; target++){
                boolean notTake = prev[target]; 
                boolean take = false; 
                if(target >= nums[index]){
                    take = prev[target - nums[index]]; 
                }
                curr[target] = take || notTake; 
            }
            prev = curr; 
        }
        return prev[sumToLookFor]; 
    }
}