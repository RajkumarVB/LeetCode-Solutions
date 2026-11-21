/*
 * 2149. Rearrange Array Elements by Sign  [Medium]
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 * Topics: Array, Two Pointers, Simulation
 *
 * Problem:     An array has equally many positives and negatives. Rearrange it to alternate
 *              positive, negative, ..., starting with a positive, keeping relative order
 *              within each sign.
 * Example:     [3,1,-2,-5,2,-4] -> [3,-2,1,-5,2,-4]
 * Constraints: n <= 2e5
 *
 * Key idea:    Two write pointers into a new array: positives go to even indices (0, 2,
 *              ...), negatives to odd (1, 3, ...).
 *
 * Approach:    Split into two lists, then interleave
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: Even/odd write pointers
 * Submitted:   2023-08-24 (submission 1030227349, AC)
 */

class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> positives = new ArrayList<>(); 
        ArrayList<Integer> negatives = new ArrayList<>();
        int n = nums.length; 
        for(int element : nums){
            if(element < 0){
                negatives.add(element);
            } else{
                positives.add(element);
            }
        }
        int[] res = new int[n];
        for(int i=0; i<n/2 ;i++){
            res[i*2] = positives.get(i);
            res[i*2 + 1] = negatives.get(i);
        }
        return res; 
    }
}