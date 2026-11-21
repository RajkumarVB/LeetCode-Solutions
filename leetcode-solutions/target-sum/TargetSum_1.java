/*
 * 494. Target Sum  [Medium]
 * https://leetcode.com/problems/target-sum/
 * Topics: Array, Dynamic Programming, Backtracking, Knapsack Problem, 0-1 Knapsack
 *
 * Problem:     Put + or - before each number. Count the expressions that evaluate to
 *              target.
 * Example:     [1,1,1,1,1], target=3 -> 5
 * Constraints: n <= 20, sum <= 1000
 *
 * Key idea:    Memoise (index, running sum). Algebra trick: if P is the positive set, P =
 *              (total + target) / 2, so it becomes 'count subsets with sum P', a 0/1
 *              knapsack.
 *
 * Approach:    Recursion + memo on (i, sum)
 * Complexity:  time O(n * sum), space O(n * sum)
 * Also see:    _2: Plain recursion (2^n)
 * Submitted:   2024-04-09 (submission 1227867605, AC)
 */

class Solution {
    HashMap<Pair,Integer> map = new HashMap<>(); 
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return findWays(n-1,0, nums, target); 
    }
    public int findWays(int i, int sum, int[] nums, int target){
        if(i < 0){
            if(target == sum) return 1; 
            return 0; 
        }
        Pair p = new Pair(i,sum); 
        if(map.containsKey(p)) return map.get(p); 

        int pos = findWays(i-1,sum+nums[i], nums, target);
        int neg = findWays(i-1,sum-nums[i], nums, target);
        
        map.put(p, pos+neg); 
        return pos + neg; 
    }
    record Pair(int i, int sum){

    }
}