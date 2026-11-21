/*
 * 485. Max Consecutive Ones  [Easy]
 * https://leetcode.com/problems/max-consecutive-ones/
 * Topics: Array
 *
 * Problem:     Return the longest run of consecutive 1s in a binary array.
 * Example:     [1,1,0,1,1,1] -> 3
 * Constraints: n <= 1e5
 *
 * Key idea:    Running counter that resets on 0; track the maximum.
 *
 * Approach:    Running counter
 * Complexity:  time O(n), space O(1)
 * Submitted:   2023-12-23 (submission 1126802224, AC)
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result =0 , counter=0 ;
        for(int i : nums){
            if(i == 1){
                counter += 1; 
                result = Math.max(result, counter); 
            } else {
                counter =0 ; 
            }
        }
        return result; 
    }
}