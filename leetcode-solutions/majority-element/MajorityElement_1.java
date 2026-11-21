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
 * Approach:    Boyer-Moore voting
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: HashMap counting
 * Submitted:   2023-08-22 (submission 1028270992, AC)
 */

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0 ; 
        int res = Integer.MIN_VALUE ;
        for(int element : nums){
            if(count ==0){
                count++;
                res = element; 
            } else if (element == res){
                count++;
            } else {
                count --; 
            }
        }
        return res; 
    }
}