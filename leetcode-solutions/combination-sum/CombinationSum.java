/*
 * 39. Combination Sum  [Medium]
 * https://leetcode.com/problems/combination-sum/
 * Topics: Array, Backtracking
 *
 * Problem:     Return all unique combinations of distinct candidates (each usable unlimited
 *              times) that sum to target.
 * Example:     candidates=[2,3,6,7], target=7 -> [[2,2,3],[7]]
 * Constraints: <= 30 candidates, target <= 40
 *
 * Key idea:    Backtracking with 'take (stay on same index)' or 'skip (move to next
 *              index)'. Staying on the same index allows reuse; moving forward only
 *              prevents duplicate orderings.
 *
 * Approach:    Backtracking take/skip, sorted for early pruning
 * Complexity:  time O(2^target) roughly, space O(target) depth
 * Submitted:   2026-01-21 (submission 1892254441, AC)
 */

class Solution {
    private List<List<Integer>> result ; 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new LinkedList<>();
        Arrays.sort(candidates); 
        computeCombinationSum(candidates, 0, target, new LinkedList<>()); 
        return result; 
    }

    private void computeCombinationSum(int[] candidates, int idx , int target, LinkedList<Integer> takenNums){
        int n = candidates.length; 
        if(idx >= n || target - candidates[idx] < 0) return; 
        if(target - candidates[idx] == 0){
            takenNums.add(candidates[idx]);
            result.add(new LinkedList<>(takenNums));
            takenNums.removeLast();
            return; 
        }
        int newTarget = target - candidates[idx]; 
        takenNums.add(candidates[idx]);
        computeCombinationSum(candidates, idx, newTarget, takenNums);
        takenNums.removeLast();
        computeCombinationSum(candidates, idx + 1, target, takenNums);
    }
}


