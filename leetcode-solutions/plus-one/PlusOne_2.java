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
 * Approach:    General carry propagation into a deque
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: In-place from the right, early return
 * Submitted:   2023-12-23 (submission 1126382781, AC)
 */

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length; 
        Deque<Integer> deque = new LinkedList<>(); 
        int carry = 0; 
        for(int i=n-1 ; i>=0 ; i--){
            int digit = digits[i]; 
            int sum = (i == n-1) ? digit + 1 + carry : digit + carry ; 
            carry = sum /10; 
            digit = sum % 10; 
            deque.addFirst(digit); 
        }
        if(carry != 0) deque.addFirst(carry); 

        // Copying Deque to Array
        int[] result = new int[deque.size()]; 
        int i =0; 
        while(deque.size() > 0){
            result[i++] = deque.removeFirst(); 
        }

        return result ;
    }
}