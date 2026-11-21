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
 * Approach:    HashSet, count only from sequence starts
 * Complexity:  time O(n), space O(n)
 * Also see:    _2: Sort and scan (skip duplicates)
 * Submitted:   2025-09-11 (submission 1767350040, AC)
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int result = 0; 
        for(int num : set){
            if(!set.contains(num-1)){
                int count = 1; 
                int currentStartingPoint = num ; 
                while(set.contains(currentStartingPoint+count)){
                    count++; 
                }
                result = Math.max(result, count);
            }
        }
        return result; 
    }
}


// put nums[i] to a hashset