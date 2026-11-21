/*
 * 875. Koko Eating Bananas  [Medium]
 * https://leetcode.com/problems/koko-eating-bananas/
 * Topics: Array, Binary Search
 *
 * Problem:     Koko eats at k bananas/hour, one pile per hour (leftovers wasted). Find the
 *              smallest k that finishes all piles within h hours.
 * Example:     piles=[3,6,7,11], h=8 -> 4
 * Constraints: n <= 1e4, piles up to 1e9
 *
 * Key idea:    Binary search on the answer: speeds 1..max(pile). Hours needed = sum(ceil(p
 *              / k)) decreases as k increases, so find the first k with hours <= h. Watch
 *              for int overflow in the hours sum.
 *
 * Approach:    Binary search on speed
 * Complexity:  time O(n log max), space O(1)
 * Submitted:   2025-09-23 (submission 1780447346, AC)
 */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = findMax(piles); 
        int left = 1, right = maxPile; 
        int result = maxPile; 
        while(left <= right){
            int mid = (right - left) / 2 + left; 
            if(canEatAtGivenSpeed(mid, piles, h)){
                result = Math.min(result,mid); 
                right = mid -1 ;
            }else{
                left = mid + 1; 
            }
        }
        return result; 
    }

    private boolean canEatAtGivenSpeed(int speed, int[] piles, int h){
        double totalHours = 0; 
        for(int pile : piles){
            int hour = (int) Math.ceil((double) pile / speed); 
            totalHours += hour; 
        }
        return totalHours <= h; 
    }
    private int findMax(int[] piles){
        int max = piles[0];
        for(int pile : piles){
            max = Math.max(max, pile);
        }
        return max; 
    }
}