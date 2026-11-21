/*
 * 78. Subsets  [Medium]
 * https://leetcode.com/problems/subsets/
 * Topics: Array, Backtracking, Bit Manipulation
 *
 * Problem:     Return every subset of an array of unique integers.
 * Example:     [1,2,3] -> 8 subsets
 * Constraints: n <= 10
 *
 * Key idea:    For each element choose take or skip (2^n leaves). Equivalently, every mask
 *              0..2^n - 1 picks the elements whose bits are set.
 *
 * Approach:    Bitmask enumeration
 * Complexity:  time O(n * 2^n), space O(1) extra
 * Also see:    _1: Backtracking take / skip
 * Submitted:   2025-04-05 (submission 1597156414, AC)
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length; 
        List<List<Integer>> ans = new LinkedList<>(); 
        for(int i=0; i<= ((1 << n) - 1); i++){
            List<Integer> tempAns = new LinkedList<>(); 
            for(int j=0; j<n; j++){
                if((i & (1 << j)) != 0){
                    tempAns.add(nums[j]); 
                }
            }
            ans.add(tempAns); 
        }
        return ans; 
    }
}