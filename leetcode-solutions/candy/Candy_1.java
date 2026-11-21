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
 * Approach:    Two passes with left[] and right[] arrays
 * Complexity:  time O(n), space O(n)
 * Also see:    _2: Left pass array + right pass with a running counter
 * Submitted:   2026-01-17 (submission 1887119859, AC)
 */

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length; 
        int[] satisfyLeft = new int[n];
        int[] satisfyRight = new int[n];
        
        satisfyLeft[0] = 1; 
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                satisfyLeft[i] = satisfyLeft[i-1] + 1; 
            }else{
                satisfyLeft[i] =1; 
            }
        }
        satisfyRight[n-1] = 1; 
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                satisfyRight[i] = satisfyRight[i+1] + 1; 
            }else{
                satisfyRight[i] =1; 
            }
        }

        int totalCandies = 0; 
        for(int i=0; i<n; i++){
            totalCandies += Math.max(satisfyLeft[i], satisfyRight[i]);
        }
        return totalCandies; 
    }
}

// 1,2,2

// 1 2 1

// 1 2 3 4 2 4 1 8

// 1 2 3 4 1 2 1 2 

// 1 2 3 4 1 2 1 2 
// 1 1 1 2 1 2 1 1