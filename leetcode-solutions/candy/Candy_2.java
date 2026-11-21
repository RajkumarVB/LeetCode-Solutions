/*
 * 135. Candy  [Hard]
 * https://leetcode.com/problems/candy/
 * Topics: Array, Greedy
 *
 * Problem:     Children stand in a line with ratings. Everyone gets at least one candy and
 *              a child with a higher rating than a neighbour must get more than that
 *              neighbour. Return the minimum total candies.
 * Example:     [1,0,2] -> 5 (2,1,2)
 * Constraints: n <= 5e4
 *
 * Key idea:    Two passes: left-to-right satisfies the left neighbour rule, right-to-left
 *              satisfies the right one; each child gets the max of the two requirements.
 *
 * Approach:    Left pass array + right pass with a running counter
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: Two passes with left[] and right[] arrays
 * Submitted:   2026-01-17 (submission 1887134410, AC)
 */

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length; 
        int[] satisfyLeft = new int[n];
    
        satisfyLeft[0] = 1; 
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                satisfyLeft[i] = satisfyLeft[i-1] + 1; 
            }else{
                satisfyLeft[i] =1; 
            }
        }

        int totalCandies = Math.max(1, satisfyLeft[n-1]); 
        int prevGiven = 1; 
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                totalCandies += Math.max(prevGiven + 1, satisfyLeft[i]); 
                prevGiven += 1; 
            }else{
                prevGiven = 1; 
                totalCandies += Math.max(1, satisfyLeft[i]); 
            }
        }
        
        return totalCandies; 
    }
}

// 1 2 2 

// 1 2 1 
// 1 1 1

// 2 1 2 
// 1 1 2
// 2 1 1