/*
 * 66. Plus One  [Easy]
 * https://leetcode.com/problems/plus-one/
 * Topics: Array, Math
 *
 * Problem:     Add one to a big integer stored as an array of digits.
 * Example:     [1,2,9] -> [1,3,0]; [9,9] -> [1,0,0]
 * Constraints: length <= 100
 *
 * Key idea:    From the right: if a digit is < 9, increment it and return. Otherwise set it
 *              to 0 and continue. If every digit was 9, return a new array [1, 0, ..., 0].
 *
 * Approach:    In-place from the right, early return
 * Complexity:  time O(n), space O(1) usually
 * Also see:    _2: General carry propagation into a deque
 * Submitted:   2023-12-23 (submission 1126389003, AC)
 */

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length; 
        for(int i = n-1; i>=0 ;i--){
            if(digits[i] < 9){
                digits[i] ++; 
                return digits; 
            }
            digits[i] = 0; 
        }

        digits = new int[n+1] ; 
        digits[0] =1; 
        return digits; 
    }
}