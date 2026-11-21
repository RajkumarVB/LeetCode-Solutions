/*
 * 1422. Maximum Score After Splitting a String  [Easy]
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 * Topics: String, Prefix Sum
 *
 * Problem:     Split a binary string into two non-empty parts. Score = zeros in the left +
 *              ones in the right. Return the maximum score.
 * Example:     "011101" -> 5
 * Constraints: n <= 500
 *
 * Key idea:    Precompute suffix counts of ones (or start with the total ones and subtract
 *              as you go), then scan each split point once.
 *
 * Approach:    Suffix count of ones + one scan
 * Complexity:  time O(n), space O(n)
 * Also see:    _2: Brute force recount per split
 * Submitted:   2023-12-22 (submission 1125862784, AC)
 */

class Solution {
    public int maxScore(String s) {
        int n = s.length(); 
        int[] rightOnesCount = new int[n]; 
        int rightCount =0 ; 

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '1'){
                rightCount++; 
            }
            rightOnesCount[i] = rightCount; 
        }

        int result  =0 , leftScore =0; 
        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == '0') leftScore++; 
            int rightScore = rightOnesCount[i+1]; 
            result = Math.max(leftScore + rightScore, result); 
        }
        return result; 
    }
}