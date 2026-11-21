/*
 * 416. Partition Equal Subset Sum  [Medium]
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * Topics: Array, Dynamic Programming, Knapsack Problem, 0-1 Knapsack
 *
 * Problem:     Can the array be split into two subsets with equal sums?
 * Example:     [1,5,11,5] -> true
 * Constraints: n <= 200, values <= 100
 *
 * Key idea:    If the total is odd, it's impossible. Otherwise it's subset-sum to total/2
 *              (0/1 knapsack): canMake(i, t) = canMake(i-1, t) || canMake(i-1, t -
 *              nums[i]).
 *
 * Approach:    Bottom-up subset-sum with two rows
 * Complexity:  time O(n * sum), space O(sum)
 * Also see:    _2: Top-down memo (take / not take)
 * Submitted:   2024-01-18 (submission 1149735197, AC)
 */

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