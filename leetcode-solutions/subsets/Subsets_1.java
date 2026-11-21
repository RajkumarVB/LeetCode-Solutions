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
 * Approach:    Backtracking take / skip
 * Complexity:  time O(n * 2^n), space O(n)
 * Also see:    _2: Bitmask enumeration
 * Submitted:   2025-04-05 (submission 1597159914, AC)
 */

class Solution {
    List<List<Integer>> ans = new LinkedList<>(); 
    public List<List<Integer>> subsets(int[] nums) {
        computeSubsets(nums,0,new LinkedList<>()); 
        return ans; 
    }
    private void computeSubsets(int[] nums, int i ,List<Integer> tempAns){
        if(i == nums.length){
            ans.add(new LinkedList<>(tempAns)); 
            return; 
        }
        tempAns.add(nums[i]);
        computeSubsets(nums,i+1,tempAns); 
        tempAns.remove(tempAns.size() -1 ); 
        computeSubsets(nums,i+1,tempAns); 
    }
}