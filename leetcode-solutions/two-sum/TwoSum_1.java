/*
 * 1. Two Sum  [Easy]
 * https://leetcode.com/problems/two-sum/
 * Topics: Array, Hash Table
 *
 * Problem:     Return the indices of the two numbers that add up to target (exactly one
 *              solution).
 * Example:     [2,7,11,15], target=9 -> [0,1]
 * Constraints: n <= 1e4
 *
 * Key idea:    One pass with a HashMap value -> index: for each x, if target - x has been
 *              seen, you're done; otherwise store x.
 *
 * Approach:    One-pass HashMap of complements
 * Complexity:  time O(n), space O(n)
 * Also see:    _2: Brute force pairs
 * Submitted:   2026-09-02 (submission 2128690532, AC)
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length; 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int elementToLookFor = target - nums[i]; 
            if(map.containsKey(elementToLookFor)){
                return new int[]{i, map.get(elementToLookFor)}; 
            }
            map.put(nums[i], i); 
        }
        return new int[]{-1,-1}; 
    }
}