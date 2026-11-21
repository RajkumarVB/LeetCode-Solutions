/*
 * 90. Subsets II  [Medium]
 * https://leetcode.com/problems/subsets-ii/
 * Topics: Array, Backtracking, Bit Manipulation
 *
 * Problem:     Return all distinct subsets when the input may contain duplicates.
 * Example:     [1,2,2] -> [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Constraints: n <= 10
 *
 * Key idea:    Sort first. In the take/skip recursion, when you skip a value, also skip all
 *              its duplicates, so the same value isn't excluded in two different ways.
 *
 * Approach:    Bitmask + sort each subset into a HashSet
 * Complexity:  time O(n log n * 2^n), space O(2^n)
 * Also see:    _1: Sort + backtracking, skip duplicates on 'skip'
 * Submitted:   2024-03-14 (submission 1203326040, AC)
 */

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length; 
        int subsets = 1 << n; 
        HashSet<List<Integer>> result = new HashSet<>(); 
        for(int i=0; i<subsets; i++){
            List<Integer> tempResult = new LinkedList<>(); 
            for(int j=0; j<n; j++){
                // Check whether j'th bit is set or not in i 
                if(((1 << j) & i) != 0) tempResult.add(nums[j]); 
            }
            tempResult.sort(null); 
            result.add(tempResult);
        }
        return new LinkedList<>(result); 
    }
}