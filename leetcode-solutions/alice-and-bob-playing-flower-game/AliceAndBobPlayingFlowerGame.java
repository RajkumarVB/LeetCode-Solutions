/*
 * 3021. Alice and Bob Playing Flower Game  [Medium]
 * https://leetcode.com/problems/alice-and-bob-playing-flower-game/
 * Topics: Math
 *
 * Problem:     Alice picks x in [1,n] flowers for one lane and y in [1,m] for the other;
 *              players alternately remove one flower and whoever takes the last one wins.
 *              Count pairs (x,y) where Alice (who moves first) wins.
 * Example:     n=3, m=2 -> 3
 * Constraints: 1 <= n, m <= 1e5
 *
 * Key idea:    Alice wins exactly when x + y is odd, i.e. one is odd and the other even.
 *              Answer = odd(n)*even(m) + even(n)*odd(m) = (n*m)/2.
 *
 * Approach:    Parity counting per x
 * Complexity:  time O(n), space O(1)
 * Submitted:   2025-08-29 (submission 1752683514, AC)
 */

class Solution {
    public long flowerGame(int n, int m) {
        long ans =0; 
        for(int i=1; i<=n; i++){
            if(i % 2 == 0){
                // i is even, you need the reuslt to be odd, so calculate no of odd number between 1 and m
                ans += noOfOddNumbers(m); 
            }else{
                ans += noOfEvenNumbers(m); 
            }
        }
        return ans; 
    }

    public long noOfOddNumbers(int x){
        if(x % 2 == 0) return x /2; 
        return ((x/2) + 1); 
    }
    public long noOfEvenNumbers(int x){
        return x /2; 
    }
}

