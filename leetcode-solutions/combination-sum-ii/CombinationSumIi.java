/*
 * 40. Combination Sum II  [Medium]
 * https://leetcode.com/problems/combination-sum-ii/
 * Topics: Array, Backtracking
 *
 * Problem:     Like Combination Sum, but each candidate can be used once and the input may
 *              contain duplicates; no duplicate combinations allowed.
 * Example:     candidates=[10,1,2,7,6,1,5], target=8 -> [[1,1,6],[1,2,5],[1,7],[2,6]]
 * Constraints: <= 100 candidates, target <= 30
 *
 * Key idea:    Sort, then in the for-loop skip candidates[k] == candidates[k-1] when k >
 *              start: the same value is never chosen twice at the same depth. Break early
 *              once the sum exceeds target.
 *
 * Approach:    Sort + for-loop backtracking with duplicate skip
 * Complexity:  time O(2^n), space O(n)
 * Submitted:   2024-03-16 (submission 1205229347, AC)
 */

class Solution {
    int[] candidates;
    int target; 
    List<List<Integer>> result = new LinkedList<>(); 
    int n;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates; 
        this.target = target; 
        this.n = candidates.length; 
        backtrack(0,0,new LinkedList<>()); 
        return result; 
    }
    public void backtrack(int i, long sum, List<Integer> tempResult){
        if(sum == target){
            result.add(new LinkedList<>(tempResult));
            return; 
        }
        for(int k=i; k<n; k++){
            if(sum + candidates[k] > target) break;
            if(k != i && candidates[k] == candidates[k-1]) continue; 
            tempResult.add(candidates[k]);
            backtrack(k+1, sum + candidates[k], tempResult);
            tempResult.removeLast(); 
        }
    }
}