/*
 * 202. Happy Number  [Easy]
 * https://leetcode.com/problems/happy-number/
 * Topics: Hash Table, Math, Two Pointers, Floyd's Cycle Finding Algorithm
 *
 * Problem:     Repeatedly replace n by the sum of the squares of its digits. n is happy if
 *              this reaches 1; otherwise it loops forever.
 * Example:     19 -> true (1+81=82, 68, 100, 1)
 * Constraints: n <= 2^31 - 1
 *
 * Key idea:    Either it reaches 1 or enters a cycle. Detect the cycle with a HashSet of
 *              seen values (or Floyd's slow/fast pointers for O(1) space).
 *
 * Approach:    HashSet cycle detection
 * Complexity:  time O(log n) per step, space O(cycle length)
 * Submitted:   2023-12-27 (submission 1129532711, AC)
 */

class Solution {
    public boolean isHappy(int n) {
        HashSet<Long> set = new HashSet<>(); 
        set.add((long) n); 

        long squareNo = n; 
        while(squareNo != 1){
            squareNo = square(squareNo); 
            if(set.contains(squareNo)) return false; 
            set.add(squareNo); 
        }

        return true; 
    }
    public static long square(long n){
        long ans =0; 
        while(n !=0){
            int lastDigit = (int) (n % 10); 
            ans += Math.pow(lastDigit,2); 
            n /= 10; 
        }
        return ans; 
    }
}