/*
 * 45. Jump Game II  [Medium]
 * https://leetcode.com/problems/jump-game-ii/
 * Topics: Array, Dynamic Programming, Greedy
 *
 * Problem:     Same jump array; return the minimum number of jumps to reach the last index
 *              (always possible).
 * Example:     [2,3,1,1,4] -> 2
 * Constraints: n <= 1e4
 *
 * Key idea:    BFS by windows: [l, r] are the indices reachable with 'jumps' jumps; the
 *              next window ends at the farthest i + nums[i] from the current window.
 *
 * Approach:    Greedy BFS over reachable windows
 * Complexity:  time O(n), space O(1)
 * Submitted:   2024-02-27 (submission 1187357964, AC)
 */

class Solution {
    public int jump(int[] nums) {
        int n = nums.length; 
        int l=0, r=0; 
        int farthest = 0; 
        int result = 0; 
        while(r < n -1){
            for(int i=l; i<=r; i++){
                farthest = Math.max(farthest, i + nums[i]); 
            }
            l = r + 1; 
            r = farthest; 
            result ++; 
        }
        return result; 
    }
}