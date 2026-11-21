/*
 * 169. Majority Element  [Easy]
 * https://leetcode.com/problems/majority-element/
 * Topics: Array, Hash Table, Divide and Conquer, Sorting, Counting, Boyer–Moore Majority
 *         Vote Algorithm
 *
 * Problem:     Return the element that appears more than n/2 times (it always exists).
 * Example:     [2,2,1,1,1,2,2] -> 2
 * Constraints: n <= 5e4
 *
 * Key idea:    Boyer-Moore voting: keep a candidate and a count. Matching elements
 *              increment, others decrement, and at count 0 take a new candidate. The
 *              majority survives.
 *
 * Approach:    HashMap counting
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: Boyer-Moore voting
 * Submitted:   2023-08-22 (submission 1028275934, AC)
 */

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int n = nums.length; 
        for(int i=0; i<n; i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }
        for(var entry : hashMap.entrySet()){
            if(entry.getValue() > n/2) return entry.getKey();
        }
        return -1; 
    }
}