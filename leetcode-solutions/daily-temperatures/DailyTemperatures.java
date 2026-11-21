/*
 * 739. Daily Temperatures  [Medium]
 * https://leetcode.com/problems/daily-temperatures/
 * Topics: Array, Stack, Monotonic Stack
 *
 * Problem:     For each day, return how many days until a warmer temperature (0 if none).
 * Example:     [73,74,75,71,69,72,76,73] -> [1,1,4,2,1,1,0,0]
 * Constraints: n <= 1e5
 *
 * Key idea:    Monotonic stack of indices (next greater element). Scanning right to left,
 *              pop indices whose temperature is <= today's; the top is the next warmer day.
 *
 * Approach:    Monotonic decreasing stack, right to left
 * Complexity:  time O(n), space O(n)
 * Submitted:   2025-09-17 (submission 1774197312, AC)
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>(); 
        int n = temperatures.length; 
        int[] result = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && temperatures[stack.getLast()] <= temperatures[i]){
                stack.removeLast(); 
            }
            result[i] = !stack.isEmpty() ? (stack.getLast() - i) : 0; 
            stack.addLast(i);
        }
        return result; 
    }
}