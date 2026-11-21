/*
 * 2364. Count Number of Bad Pairs  [Medium]
 * https://leetcode.com/problems/count-number-of-bad-pairs/
 * Topics: Array, Hash Table, Math, Counting
 *
 * Problem:     A pair (i, j) with i < j is bad if j - i != nums[j] - nums[i]. Count the bad
 *              pairs.
 * Example:     [4,1,3,3] -> 5
 * Constraints: n <= 1e5
 *
 * Key idea:    Rearrange: a pair is GOOD when nums[i] - i == nums[j] - j. Count good pairs
 *              with a HashMap of (nums[k] - k) frequencies, then bad = n(n-1)/2 - good. Use
 *              long.
 *
 * STATUS:      NOT ACCEPTED - this is your latest attempt. Earlier attempts are in
 *              attempts/.
 * Submitted:   2025-02-10 (submission 1537362422, TLE)
 */

class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length; 
        int badPairsCount = 0; 
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                // Check if (i, j) is a bad pair
                if(isBadPair(nums,i,j)){
                    badPairsCount ++; 
                } 
            }
        }
        return badPairsCount; 
    }
    public boolean isBadPair(int[] nums, int i, int j){
        return (nums[j] - nums[i]) != (j - i); 
    }
}