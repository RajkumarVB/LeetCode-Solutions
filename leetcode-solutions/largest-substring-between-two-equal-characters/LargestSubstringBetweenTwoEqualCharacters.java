/*
 * 1624. Largest Substring Between Two Equal Characters  [Easy]
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 * Topics: Hash Table, String
 *
 * Problem:     Return the length of the longest substring between two equal characters
 *              (excluding them), or -1.
 * Example:     "abca" -> 2
 * Constraints: n <= 300
 *
 * Key idea:    Store each character's first index; for each later occurrence the answer
 *              candidate is i - first[c] - 1. That's a single pass. (Your memoised interval
 *              recursion is O(n^2).)
 *
 * Approach:    Memoised recursion on (i, j)
 * Complexity:  time O(n^2), space O(n^2)
 * Submitted:   2024-01-01 (submission 1133230358, AC)
 */

class Solution {
    private String s;
    HashMap<Pair<Integer,Integer>, Integer> memoMap = new HashMap<>(); 
    
    public int maxLengthBetweenEqualCharacters(String s) {
        this.s = s; 
        int n = s.length(); 
        return solve(0,n-1); 
    }

    public int solve(int i, int j){
        if(i ==j) return -1; 
        
        if(s.charAt(i) == s.charAt(j)){
            return (j - i -1); 
        }
        Pair p = new Pair(i,j);
        if(memoMap.containsKey(p)) return memoMap.get(p); 

        int tempAns1 = solve(i+1, j);
        int tempAns2 = solve(i, j-1);

        int result = Math.max(tempAns1, tempAns2); 
        memoMap.put(p,result);
        return result; 
    }

}