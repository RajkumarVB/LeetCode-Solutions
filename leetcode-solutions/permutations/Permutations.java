/*
 * 46. Permutations  [Medium]
 * https://leetcode.com/problems/permutations/
 * Topics: Array, Backtracking
 *
 * Problem:     Return all permutations of distinct integers.
 * Example:     [1,2,3] -> 6 permutations
 * Constraints: n <= 6
 *
 * Key idea:    Backtracking: at each level pick any unused number (a boolean[] or set of
 *              used values), recurse, then un-pick it. Alternative: swap nums[i] into
 *              position start.
 *
 * Approach:    Backtracking with LinkedHashSet of used values
 * Complexity:  time O(n * n!), space O(n)
 * Submitted:   2024-03-15 (submission 1204575889, AC)
 */

class Solution {
    List<List<Integer>> result = new LinkedList<>(); 
    int n ; 
    int[] nums; 
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums; 
        this.n = nums.length; 
        backtrack(new LinkedHashSet<>()); 
        return result; 
    }
    public void backtrack(LinkedHashSet<Integer> set){
        if(set.size() == n){
            result.add(new LinkedList<>(set));
            return; 
        }
        for(int i=0; i<n; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]); 
                backtrack(set); 
                set.remove(nums[i]);
            }
        }
    }
}