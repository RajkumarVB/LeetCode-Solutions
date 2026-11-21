/*
 * 128. Longest Consecutive Sequence  [Medium]
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * Topics: Array, Hash Table, Union-Find
 *
 * Problem:     Return the length of the longest run of consecutive integers present in an
 *              unsorted array, in O(n).
 * Example:     [100,4,200,1,3,2] -> 4 (1,2,3,4)
 * Constraints: n <= 1e5
 *
 * Key idea:    Put everything in a HashSet. Only start counting from numbers with no
 *              predecessor (x-1 not in set) and walk upward, so each number is visited O(1)
 *              times.
 *
 * Approach:    Sort and scan (skip duplicates)
 * Complexity:  time O(n log n), space O(1)
 * Also see:    _1: HashSet, count only from sequence starts
 * Submitted:   2023-09-04 (submission 1040140772, AC)
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length; 
        if(n ==0) return 0; 
        Arrays.sort(nums);
        int result =1 , count =1, prev = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i]-1 == prev){
                count ++; 
                prev = nums[i];
            }else if(nums[i] != prev){
                count = 1; 
                prev = nums[i];
            }
            result = Math.max(result, count);
        }
        return result; 
    }
}