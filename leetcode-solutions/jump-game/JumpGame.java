/*
 * 55. Jump Game  [Medium]
 * https://leetcode.com/problems/jump-game/
 * Topics: Array, Dynamic Programming, Greedy
 *
 * Problem:     nums[i] is the maximum jump from index i. Can you reach the last index from
 *              index 0?
 * Example:     [2,3,1,1,4] -> true; [3,2,1,0,4] -> false
 * Constraints: n <= 1e4
 *
 * Key idea:    Walk backwards keeping a 'goal': if i + nums[i] >= goal, then i can reach it
 *              and becomes the new goal. Answer: goal == 0.
 *
 * Approach:    Greedy, move goal backwards
 * Complexity:  time O(n), space O(1)
 * Submitted:   2024-02-25 (submission 1185939737, AC)
 */

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length; 
        int goal = n-1; 
        for(int i=n-2; i>=0; i--){
            if(i + nums[i] >= goal){
                goal = i; 
            }
        }
        return goal ==0; 
    }
}