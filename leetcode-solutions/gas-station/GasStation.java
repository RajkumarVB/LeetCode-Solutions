/*
 * 134. Gas Station  [Medium]
 * https://leetcode.com/problems/gas-station/
 * Topics: Array, Greedy
 *
 * Problem:     Stations on a circle have gas[i] and it costs cost[i] to reach the next one.
 *              Return the start index that lets you complete the loop, or -1.
 * Example:     gas=[1,2,3,4,5], cost=[3,4,5,1,2] -> 3
 * Constraints: n <= 1e5, answer unique
 *
 * Key idea:    If total gas < total cost, it's impossible. Otherwise scan with a running
 *              tank; whenever it goes negative, no station in the current stretch can be
 *              the start, so restart from i+1.
 *
 * Approach:    Total check + reset start when tank < 0
 * Complexity:  time O(n), space O(1)
 * Submitted:   2024-02-25 (submission 1185959900, AC)
 */

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        long gasSum = sum(gas);
        long costSum = sum(cost);
        if(costSum > gasSum ) return -1; 
        int n = gas.length; 

        // At this point, we can surely say that, we have a solution.
        long gasLeft =0; 
        int result  = 0; 
        for(int i=0; i<n; i++) {
            gasLeft += gas[i]; 
            gasLeft -= cost[i]; 
            if(gasLeft < 0) {
                // The if will not execute if i == n-1
                // Because gasLeft < 0, then we can't have a solution. 
                // That case we have eliminated before. 
                gasLeft = 0; 
                result = i +1; 
            }
        }
        return result; 
    }
    public long sum(int[] arr){
        long sum = 0 ; 
        for(int ele : arr){
            sum += ele; 
        }
        return sum; 
    }
}