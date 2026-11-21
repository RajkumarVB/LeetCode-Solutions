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
 * Approach:    Naive recursion (for contrast)
 * Complexity:  time O(2^n), space O(n)
 * Also see:    _1: Iterative with two variables
 * Submitted:   2023-08-30 (submission 1035725866, AC)
 */

class Solution {
    public int fib(int n) {
        return solve(n);
    }
    public static int solve(int n ){
        if(n==0 || n==1) return n ; 
        return solve(n-1) + solve(n-2); 
    }
}