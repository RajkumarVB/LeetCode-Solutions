/*
 * 509. Fibonacci Number  [Easy]
 * https://leetcode.com/problems/fibonacci-number/
 * Topics: Math, Dynamic Programming, Recursion, Memoization
 *
 * Problem:     Return the nth Fibonacci number (F0 = 0, F1 = 1).
 * Example:     n=4 -> 3
 * Constraints: n <= 30
 *
 * Key idea:    Plain recursion is O(2^n) because subproblems repeat. Iterate keeping only
 *              the last two values for O(n) time and O(1) space.
 *
 * Approach:    Iterative with two variables
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: Naive recursion (for contrast)
 * Submitted:   2023-08-30 (submission 1035725019, AC)
 */

class Solution {
    public int fib(int n) {
        if (n==0 || n==1) return n ; 
        int first = 0 ; 
        int second = 1; 
        for(int i=1;i<n;i++){
            int sum = first + second; 
            first = second ; 
            second = sum ;             
        }
        return second; 
    }
}