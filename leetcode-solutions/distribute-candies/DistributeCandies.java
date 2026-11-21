/*
 * 575. Distribute Candies  [Easy]
 * https://leetcode.com/problems/distribute-candies/
 * Topics: Array, Hash Table
 *
 * Problem:     Alice may eat n/2 of her n candies. Return the maximum number of distinct
 *              candy types she can eat.
 * Example:     [1,1,2,2,3,3] -> 3
 * Constraints: n <= 1e4, even
 *
 * Key idea:    Answer = min(number of distinct types, n/2). Count types with a HashSet.
 *
 * Approach:    HashSet of types, min with n/2
 * Complexity:  time O(n), space O(n)
 * Submitted:   2026-01-15 (submission 1886012540, AC)
 */

class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>(); 

        for(int candy : candyType){
            set.add(candy);
        }

        int differentCandies = set.size(); 

        if ((candyType.length / 2) > differentCandies){
            return differentCandies; 
        }
        return candyType.length / 2 ; 
    }
}