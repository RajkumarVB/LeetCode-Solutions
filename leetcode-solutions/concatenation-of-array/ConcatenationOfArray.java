/*
 * 1929. Concatenation of Array  [Easy]
 * https://leetcode.com/problems/concatenation-of-array/
 * Topics: Array, Simulation
 *
 * Problem:     Return an array of length 2n that is nums followed by nums again.
 * Example:     [1,2,1] -> [1,2,1,1,2,1]
 * Constraints: n <= 1000
 *
 * Key idea:    result[i] = nums[i % n].
 *
 * Approach:    Index modulo n
 * Complexity:  time O(n), space O(n)
 * Submitted:   2026-09-02 (submission 2128678025, AC)
 */

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length; 
        int[] result = new int[2*n]; 
        for(int i=0;i<2*n; i++){
            result[i] = nums[i%n];
        }
        return result; 
    }
}