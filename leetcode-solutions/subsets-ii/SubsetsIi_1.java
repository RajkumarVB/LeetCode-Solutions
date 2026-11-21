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
 * Approach:    Sort + backtracking, skip duplicates on 'skip'
 * Complexity:  time O(n * 2^n), space O(n)
 * Also see:    _2: Bitmask + sort each subset into a HashSet
 * Submitted:   2024-03-14 (submission 1203350495, AC)
 */

class Solution {
    int[] nums;
    List<List<Integer>> result = new LinkedList<>();
    int n ;  
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        this.nums = nums; 
        this.n = nums.length; 
        backtrack(0, new LinkedList<>()); 
        return result; 
    }
    public void backtrack(int i, List<Integer> tempResult){
        if(i==n){
            result.add(new ArrayList<>(tempResult));
            return;
        }
        tempResult.add(nums[i]);
        backtrack(i+1, tempResult);
        tempResult.removeLast(); 
        while((i < n-1) && (nums[i] == nums[i+1])){
            i++; 
        }
        backtrack(i+1, tempResult);
    }
}